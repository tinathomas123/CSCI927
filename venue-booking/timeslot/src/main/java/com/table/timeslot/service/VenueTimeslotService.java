package com.table.timeslot.service;

import com.table.timeslot.entity.VenueTimeslot;
import com.table.timeslot.repository.VenueTimeslotRepository;
import com.table.timeslot.response.VenueTimeslotListResponse;
import com.table.timeslot.response.VenueTimeslotResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VenueTimeslotService {

    @Autowired
    private VenueTimeslotRepository venueTimeslotRepo;

    @Autowired
    private ModelMapper mapper;

    public VenueTimeslotListResponse getTimeslotsForSelectedVenue(String selectedVenue)
    {
        VenueTimeslotListResponse venueTimeslotListResponse=new VenueTimeslotListResponse();
        List<VenueTimeslotResponse> timeslotResponses=new ArrayList<>();
        List<VenueTimeslot> timeslotList= venueTimeslotRepo.findBySelectedVenue(selectedVenue);
        for(VenueTimeslot timeslot: timeslotList)
        {
            VenueTimeslotResponse timeslotResponse=new VenueTimeslotResponse();
            timeslotResponse.setDateTime(timeslot.getDate_time().toString());
            timeslotResponse.setDay(timeslot.getDay());
            timeslotResponse.setSelectedVenue(timeslot.getSelectedVenue());
            timeslotResponses.add(timeslotResponse);
        }
        venueTimeslotListResponse.setTimeslotList(timeslotResponses);
        return venueTimeslotListResponse;
    }
}
