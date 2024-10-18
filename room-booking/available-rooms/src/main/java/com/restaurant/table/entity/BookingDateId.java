package com.restaurant.table.entity;

import java.io.Serializable;

public class BookingDateId implements Serializable {

    private String day;
    private String date;
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
