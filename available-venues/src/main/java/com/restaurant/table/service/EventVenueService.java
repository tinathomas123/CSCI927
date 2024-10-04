package com.restaurant.table.service;

import com.restaurant.table.entity.EventVenue;
import com.restaurant.table.repository.EventVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EventVenueService {

    @Autowired
    private EventVenueRepository venueRepo;

    @Autowired
    private ModelMapper mapper;

    public List<EventVenue> getAvailableVenues()
    {
        return venueRepo.findByStatus("Available");
    }
}
