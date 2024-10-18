package com.table.timeslot.response;

import java.util.List;

public class VenueTimeslotListResponse {

    private List<VenueTimeslotResponse> timeslotList;

    public List<VenueTimeslotResponse> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<VenueTimeslotResponse> timeslotList) {
        this.timeslotList = timeslotList;
    }

}
