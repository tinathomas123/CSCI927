package com.table.payment.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="TIMESLOT")
@IdClass(TableTimeslotId.class)
public class Payment {

    @Id
    @Column(name = "day")
    private String day;

    @Id
    @Column(name = "date_time")
    private Timestamp date_time;

    @Id
    @Column(name = "selectedTable")
    private String selectedTable;

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

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }
}
