package com.table.timeslot.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="TIMESLOT")
@IdClass(VenueTimeslotId.class)
public class VenueTimeslot {

    @Id
    @Column(name = "day")
    private String day;

    @Id
    @Column(name = "date_time")
    private Timestamp date_time;

    @Id
    @Column(name = "selected_venue")
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
