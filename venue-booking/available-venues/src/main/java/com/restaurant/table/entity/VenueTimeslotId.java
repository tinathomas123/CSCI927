package com.restaurant.table.entity;

import java.io.Serializable;

public class VenueTimeslotId implements Serializable {

    private String day;
    private String date_time;
    private String selectedVenue;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getSelectedVenue() {
        return selectedVenue;
    }

    public void setSelectedVenue(String selectedVenue) {
        this.selectedVenue = selectedVenue;
    }
}
