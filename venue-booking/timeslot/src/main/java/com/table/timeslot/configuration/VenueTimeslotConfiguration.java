package com.table.timeslot.configuration;

import com.table.timeslot.service.VenueTimeslotService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VenueTimeslotConfiguration {

    @Bean
    public VenueTimeslotService venueTimeslotServiceBean() {
        return new VenueTimeslotService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
