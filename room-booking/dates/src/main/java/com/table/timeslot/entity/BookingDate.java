package com.table.timeslot.entity;

import jakarta.persistence.*;

@Entity
@Table(name="BOOKINGDATE")
@IdClass(BookingDateId.class)
public class BookingDate {

    @Id
    @Column(name = "day")
    private String day;

    @Id
    @Column(name = "date")
    private String date;

    @Id
    @Column(name = "selectedRoom")
    private String selectedRoom;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(String selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
}
