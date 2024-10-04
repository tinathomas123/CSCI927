package com.restaurant.table.configuration;

import com.restaurant.table.service.CustomerDetailsService;
import com.restaurant.table.service.RoomBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomBookingConfiguration {

    @Bean
    public RoomBookingService roomBookingServiceBean() {
        return new RoomBookingService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    public CustomerDetailsService customerDetailsServiceBean(){
        return new CustomerDetailsService();
    }
}
