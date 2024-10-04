package com.restaurant.table.repository;

import com.restaurant.table.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, String> {

    public CustomerDetails findByEmail(String email);
}
