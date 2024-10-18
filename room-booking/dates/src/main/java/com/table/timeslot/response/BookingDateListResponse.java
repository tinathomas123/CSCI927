package com.table.timeslot.response;

import java.util.List;

public class BookingDateListResponse {

    private List<BookingDateResponse> availableDates;

    public List<BookingDateResponse> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<BookingDateResponse> availableDates) {
        this.availableDates = availableDates;
    }
}
