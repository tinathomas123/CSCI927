package com.restaurant.table.service;

import com.restaurant.table.entity.CustomerDetails;
import com.restaurant.table.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CustomerDetailsService
{
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    public void saveCustomerDetails(CustomerDetails customerDetails)
    {
        customerDetailsRepository.save(customerDetails);
    }

    public CustomerDetails getCustomerForEmail(String email)
    {
        return customerDetailsRepository.findByEmail(email);
    }

    public CustomerDetails getCustomerDetails(Map<String, String> userDetails) {
        CustomerDetails customerDetails=new CustomerDetails();
        customerDetails.setCustomerName(userDetails.get("customerName"));
        customerDetails.setEmail(userDetails.get("email"));
        customerDetails.setPhoneNumber(userDetails.get("phoneNumber"));
        customerDetails.setSelectedTable(userDetails.get("selectedTable"));
        customerDetails.setReservedDateTime(userDetails.get("reservedDateTime"));
        return customerDetails;
    }
}
