package com.restaurant.table.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TIMESLOT")
@IdClass(TableTimeslotId.class)
public class TableTimeslot {

    @Id
    @Column(name = "day")
    private String day;

    @Id
    @Column(name = "date_time")
    private String date_time;

    @Id
    @Column(name = "selectedTable")
    private String selectedTable;

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

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }
}
