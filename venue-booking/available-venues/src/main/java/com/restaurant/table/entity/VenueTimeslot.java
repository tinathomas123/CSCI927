package com.restaurant.table.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TIMESLOT")
@IdClass(VenueTimeslotId.class)
public class VenueTimeslot {

    @Id
    @Column(name = "day")
    private String day;

    @Id
    @Column(name = "date_time")
    private String date_time;

    @Id
    @Column(name = "selected_venue")
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

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time.toString();
    }

    public String getSelectedVenue() {
        return selectedVenue;
    }

    public void setSelectedVenue(String selectedVenue) {
        this.selectedVenue = selectedVenue;
    }
}
