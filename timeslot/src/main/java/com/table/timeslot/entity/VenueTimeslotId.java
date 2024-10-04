package com.table.timeslot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class VenueTimeslotId implements Serializable {

    private String day;
    private Timestamp date_time;
    private String selectedVenue;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getSelectedVenue() {
        return selectedVenue;
    }

    public void setSelectedVenue(String selectedVenue) {
        this.selectedVenue = selectedVenue;
    }
}
