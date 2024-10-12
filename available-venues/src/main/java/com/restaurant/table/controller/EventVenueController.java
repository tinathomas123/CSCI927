package com.restaurant.table.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.table.entity.CustomerDetails;
import com.restaurant.table.entity.EventVenue;
import com.restaurant.table.request.*;
import com.restaurant.table.response.PaymentResponse;
import com.restaurant.table.response.EventVenueResponse;
import com.restaurant.table.service.CustomerDetailsService;
import com.restaurant.table.service.EventVenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class EventVenueController {

    Logger logger = LoggerFactory.getLogger(EventVenueController.class);

    public static Map<String, String> userDetails=new HashMap<>();

    @Autowired
    EventVenueService eventVenueService;

    @Autowired
    CustomerDetailsService customerDetailsService;

    @GetMapping("/indigo-events")
    public String getEventsPlanningWebsite()
    {
        return "index.html";
    }


    @GetMapping("/available-venues")
    public String getAvailableVenues(Model model) {
        AvailableVenuesForm availableVenuesForm=new AvailableVenuesForm();
        List<EventVenue> availableVenues = eventVenueService.getAvailableVenues();
        model.addAttribute("availableVenues", availableVenues);
        model.addAttribute("availableVenuesForm", availableVenuesForm);
        return "book-venue.html";
    }

    @PostMapping("/get-timeslots")
    public String getTimeSlotsForSelectedVenue(@ModelAttribute AvailableVenuesForm availableVenuesForm, Model model) throws JsonProcessingException {

        VenueTimeslotRequest timeslotRequest=new VenueTimeslotRequest();
        timeslotRequest.setSelectedVenue(availableVenuesForm.getSelectedVenue());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString=mapper.writeValueAsString(timeslotRequest);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(jsonString,header);

        ResponseEntity<EventVenueResponse>
                responseEntity
                = new RestTemplate().postForEntity(
                "http://timeslot-api-service:7000/get-timeslots",
                entity, EventVenueResponse.class);
        EventVenueResponse response
                = responseEntity.getBody();
        if(response!=null) {
            model.addAttribute("availableTimeslots", response.getTimeslotList());
        }

        //populate userDetails map
        userDetails.put("email", availableVenuesForm.getEmail());
        userDetails.put("customerName", availableVenuesForm.getCustomerName());
        userDetails.put("phoneNumber", availableVenuesForm.getPhoneNumber());
        userDetails.put("selectedVenue", availableVenuesForm.getSelectedVenue());

        AvailableTimeslotsForm availableTimeslotsForm=new AvailableTimeslotsForm();
        availableTimeslotsForm.setSelectedVenue(availableVenuesForm.getSelectedVenue());
        model.addAttribute("availableTimeslotsForm", availableTimeslotsForm);

        logger.info("map at getTimeSlotsForSelectedTable: "+userDetails);

        return "show-timeslots.html";
    }

    @PostMapping("/submit-timeslot")
    public String submitTimeslot(@ModelAttribute AvailableTimeslotsForm availableTimeslotsForm, Model model)
    {
        userDetails.put("bookedDateTime",availableTimeslotsForm.getDateTime());

        logger.info("map at submitTimeslot: "+userDetails);

        //save booking details to DB
        CustomerDetails customerDetails=new CustomerDetails();
        customerDetails.setCustomerName(userDetails.get("customerName"));
        customerDetails.setEmail(userDetails.get("email"));
        customerDetails.setPhoneNumber(userDetails.get("phoneNumber"));
        customerDetails.setSelectedVenue(userDetails.get("selectedVenue"));
        customerDetails.setBookedDateTime(userDetails.get("bookedDateTime"));
        customerDetailsService.saveCustomerDetails(customerDetails);

        model.addAttribute("customerDetails", customerDetails);
        model.addAttribute("paymentForm", new PaymentForm());
        return "payment.html";
    }

    @PostMapping("/payment")
    public String authorizePayment(@ModelAttribute PaymentForm paymentForm, Model model) throws JsonProcessingException {

        PaymentRequest paymentRequest=new PaymentRequest();
        paymentRequest.setCardNumber(paymentForm.getCardNumber());
        paymentRequest.setCvv(paymentForm.getCvv());
        paymentRequest.setCardExpiryDate(paymentForm.getCardExpiryDate());
        paymentRequest.setCustomerName(paymentForm.getCustomerName());

        PaymentResponse response = eventVenueService.getPaymentResponse(paymentRequest);
        if(response != null && response.isAuthorized()) {

            logger.info("map at authorizePayment: "+userDetails);
            int bookingConfirmationId=new Random().nextInt(0, 99999999);
            CustomerDetails customerDetails=customerDetailsService.getCustomerForEmail(userDetails.get("email"));
            if(customerDetails!=null) {
                customerDetails.setBookingConfirmationId(String.valueOf(bookingConfirmationId));
                customerDetailsService.saveCustomerDetails(customerDetails);
            }
            model.addAttribute("customerDetails", customerDetails);

            return "booking-confirmation.html";
        }

        return "payment-error.html";
    }
}
