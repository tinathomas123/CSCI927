package com.table.timeslot.configuration;

import com.table.timeslot.service.BookingDateService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingDateConfiguration {

    @Bean
    public BookingDateService bookingDateServiceBean() {
        return new BookingDateService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
