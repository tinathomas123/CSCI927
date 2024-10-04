package com.restaurant.table.response;

import java.util.List;

public class RoomBookingResponse {

    private List<RoomBookingDateResponse> availableDates;

    public List<RoomBookingDateResponse> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<RoomBookingDateResponse> availableDates) {
        this.availableDates = availableDates;
    }
}
