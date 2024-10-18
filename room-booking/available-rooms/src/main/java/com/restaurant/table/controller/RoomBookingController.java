package com.restaurant.table.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.table.entity.CustomerDetails;
import com.restaurant.table.entity.HotelRoom;
import com.restaurant.table.request.*;
import com.restaurant.table.response.PaymentResponse;
import com.restaurant.table.response.RoomBookingResponse;
import com.restaurant.table.service.CustomerDetailsService;
import com.restaurant.table.service.RoomBookingService;
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
public class RoomBookingController {

    Logger logger = LoggerFactory.getLogger(RoomBookingController.class);

    public static Map<String, String> userDetails=new HashMap<>();

    @Autowired
    RoomBookingService roomBookingService;

    @Autowired
    CustomerDetailsService customerDetailsService;

    @GetMapping("/majestic-manor")
    public String getRoomBookingWebsite()
    {
        return "index.html";
    }


    @GetMapping("/available-rooms")
    public String getAvailableRooms(Model model) {
        AvailableRoomsForm availableRoomsForm=new AvailableRoomsForm();
        List<HotelRoom> availableRooms = roomBookingService.getAvailableTables();
        model.addAttribute("availableRooms", availableRooms);
        model.addAttribute("availableRoomsForm", availableRoomsForm);
        return "book-room.html";
    }

    @PostMapping("/get-dates")
    public String getDatesForSelectedRoom(@ModelAttribute AvailableRoomsForm availableRoomsForm, Model model) throws JsonProcessingException {

        BookingDateRequest bookingDateRequest=new BookingDateRequest();
        bookingDateRequest.setSelectedRoom(availableRoomsForm.getSelectedRoom());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString=mapper.writeValueAsString(bookingDateRequest);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(jsonString,header);

        ResponseEntity<RoomBookingResponse>
                responseEntity
                = new RestTemplate().postForEntity(
                "http://dates-api-service:7000/get-dates",
                entity, RoomBookingResponse.class);
        RoomBookingResponse response
                = responseEntity.getBody();
        if(response!=null) {
            model.addAttribute("availableDates", response.getAvailableDates());
        }

        //populate userDetails map
        userDetails.put("email", availableRoomsForm.getEmail());
        userDetails.put("customerName", availableRoomsForm.getCustomerName());
        userDetails.put("phoneNumber", availableRoomsForm.getPhoneNumber());
        userDetails.put("selectedRoom", availableRoomsForm.getSelectedRoom());

        model.addAttribute("availableDatesForm", new AvailableDatesForm());

        logger.info("map at getDatesForSelectedRoom: "+userDetails);

        return "show-dates.html";
    }

    @PostMapping("/submit-date")
    public String submitBookedDate(@ModelAttribute AvailableDatesForm availableDatesForm, Model model)
    {
        //userDetails.put("bookedDate",availableDatesForm.getDate());

        logger.info("map at submitBookedDate: "+userDetails);

        //save booking details to DB
        CustomerDetails customerDetails=new CustomerDetails();
        customerDetails.setCustomerName(userDetails.get("customerName"));
        customerDetails.setEmail(userDetails.get("email"));
        customerDetails.setPhoneNumber(userDetails.get("phoneNumber"));
        customerDetails.setSelectedRoom(userDetails.get("selectedRoom"));
        customerDetails.setBookedDate(availableDatesForm.getDate());
        customerDetailsService.saveCustomerDetails(customerDetails);

        logger.info("booked date in map at submitBookedDate: "+availableDatesForm.getDate()+", booked date in customerdetails at submitBookedDate: "+customerDetails.getBookedDate());

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

        PaymentResponse response = roomBookingService.getPaymentResponse(paymentRequest);
        if(response != null && response.isAuthorized()) {

            logger.info("map at authorizePayment: "+userDetails);
            int bookingId=new Random().nextInt(0, 99999999);
            CustomerDetails customerDetails=customerDetailsService.getCustomerForEmail(userDetails.get("email"));
            if(customerDetails!=null) {
                customerDetails.setBookingId(String.valueOf(bookingId));
                customerDetailsService.saveCustomerDetails(customerDetails);
            }
            model.addAttribute("customerDetails", customerDetails);

            return "booking-confirmation.html";
        }

        return "payment-error.html";
    }
}
