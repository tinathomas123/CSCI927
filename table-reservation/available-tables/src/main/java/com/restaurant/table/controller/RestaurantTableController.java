package com.restaurant.table.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.table.entity.CustomerDetails;
import com.restaurant.table.entity.RestaurantTable;
import com.restaurant.table.entity.TableTimeslot;
import com.restaurant.table.request.*;
import com.restaurant.table.response.PaymentResponse;
import com.restaurant.table.response.RestaurantTableResponse;
import com.restaurant.table.service.CustomerDetailsService;
import com.restaurant.table.service.RestaurantTableService;
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
public class RestaurantTableController {

    Logger logger = LoggerFactory.getLogger(RestaurantTableController.class);

    public static Map<String, String> userDetails=new HashMap<>();

    @Autowired
    RestaurantTableService restaurantTableService;

    @Autowired
    CustomerDetailsService customerDetailsService;

    @GetMapping("/silver-spoons")
    public String getRestaurantWebsite()
    {
        return "index.html";
    }


    @GetMapping("/available-tables")
    public String getAvailableTables(Model model) {
        AvailableTablesForm availableTablesForm=new AvailableTablesForm();
        List<RestaurantTable> availableTables = restaurantTableService.getAvailableTables();
        model.addAttribute("availableTables", availableTables);
        model.addAttribute("availableTablesForm", availableTablesForm);
        return "reserve-table.html";
    }

    @PostMapping("/get-timeslots")
    public String getTimeSlotsForSelectedTable(@ModelAttribute AvailableTablesForm availableTablesForm, Model model) throws JsonProcessingException {

        TableTimeslotRequest timeslotRequest=new TableTimeslotRequest();
        timeslotRequest.setSelectedTable(availableTablesForm.getSelectedTable());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString=mapper.writeValueAsString(timeslotRequest);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(jsonString,header);

        ResponseEntity<RestaurantTableResponse>
                responseEntity
                = new RestTemplate().postForEntity(
                "http://timeslot-api-service:7000/get-timeslots",
                entity, RestaurantTableResponse.class);
        RestaurantTableResponse response
                = responseEntity.getBody();
        if(response!=null) {
            model.addAttribute("availableTimeslots", response.getTimeslotList());
        }

        //populate userDetails map
        userDetails.put("email", availableTablesForm.getEmail());
        userDetails.put("customerName", availableTablesForm.getCustomerName());
        userDetails.put("phoneNumber", availableTablesForm.getPhoneNumber());
        userDetails.put("selectedTable", availableTablesForm.getSelectedTable());

        AvailableTimeslotsForm availableTimeslotsForm=new AvailableTimeslotsForm();
        availableTimeslotsForm.setSelectedTable(availableTablesForm.getSelectedTable());
        model.addAttribute("availableTimeslotsForm", availableTimeslotsForm);

        logger.info("map at getTimeSlotsForSelectedTable: "+userDetails);

        return "show-timeslots.html";
    }

    @PostMapping("/submit-timeslot")
    public String submitTimeslot(@ModelAttribute AvailableTimeslotsForm availableTimeslotsForm, Model model)
    {
        userDetails.put("reservedDateTime",availableTimeslotsForm.getDateTime());

        logger.info("map at submitTimeslot: "+userDetails);

        //save booking details to DB
        CustomerDetails customerDetails = customerDetailsService.getCustomerDetails(userDetails);
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

        PaymentResponse response = restaurantTableService.getPaymentResponse(paymentRequest);
        if(response != null && response.isAuthorized()) {

            logger.info("map at authorizePayment: "+userDetails);
            int reservationConfirmationId=new Random().nextInt(0, 99999999);
            CustomerDetails customerDetails=customerDetailsService.getCustomerForEmail(userDetails.get("email"));
            if(customerDetails!=null) {
                customerDetails.setReservationConfirmationId(String.valueOf(reservationConfirmationId));
                customerDetailsService.saveCustomerDetails(customerDetails);
            }
            model.addAttribute("customerDetails", customerDetails);

            return "reservation-confirmation.html";
        }

        return "payment-error.html";
    }


}
