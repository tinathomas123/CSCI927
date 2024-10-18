package com.restaurant.table.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.table.entity.RestaurantTable;
import com.restaurant.table.repository.RestaurantTableRepository;
import com.restaurant.table.request.PaymentRequest;
import com.restaurant.table.response.PaymentResponse;
import com.restaurant.table.response.RestaurantTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class RestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepo;

    @Autowired
    private ModelMapper mapper;

    public List<RestaurantTable> getAvailableTables()
    {
        return tableRepo.findByStatus("Available");
    }

    public PaymentResponse getPaymentResponse(PaymentRequest paymentRequest) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString=mapper.writeValueAsString(paymentRequest);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(jsonString,header);

        ResponseEntity<PaymentResponse>
                responseEntity
                = new RestTemplate().postForEntity(
                "http://payment-api-service:7001/authorize-payment",
                entity, PaymentResponse.class);
        PaymentResponse response
                = responseEntity.getBody();
        return response;
    }
}
