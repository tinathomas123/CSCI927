package com.table.timeslot;

import com.table.timeslot.request.VenueTimeslotRequest;
import com.table.timeslot.response.VenueTimeslotListResponse;
import com.table.timeslot.service.VenueTimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VenueTimeslotController {

    @Autowired
    VenueTimeslotService venueTimeslotService;

    @ResponseBody
    @PostMapping("/get-timeslots")
    public VenueTimeslotListResponse getTimeSlotsForSelectedVenue(@RequestBody VenueTimeslotRequest timeslotRequest, Model model)
    {
        VenueTimeslotListResponse response=new VenueTimeslotListResponse();
        if(timeslotRequest!=null) {
            return venueTimeslotService.getTimeslotsForSelectedVenue(timeslotRequest.getSelectedVenue());
        }
        return response;
    }
}
