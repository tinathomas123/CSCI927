package com.restaurant.table.response;

import java.util.List;

public class EventVenueResponse {

    private List<VenueTimeslotResponse> timeslotList;

    public List<VenueTimeslotResponse> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<VenueTimeslotResponse> timeslotList) {
        this.timeslotList = timeslotList;
    }
}
