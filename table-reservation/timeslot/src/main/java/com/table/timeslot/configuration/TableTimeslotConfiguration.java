package com.table.timeslot.configuration;

import com.table.timeslot.service.TableTimeslotService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableTimeslotConfiguration {

    @Bean
    public TableTimeslotService employeeBean() {
        return new TableTimeslotService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
