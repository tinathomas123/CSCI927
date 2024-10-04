package com.restaurant.table.service;

import com.restaurant.table.entity.CustomerDetails;
import com.restaurant.table.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
}
