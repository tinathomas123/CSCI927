package com.table.timeslot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class TableTimeslotId implements Serializable {

    private String day;
    private Timestamp date_time;
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
