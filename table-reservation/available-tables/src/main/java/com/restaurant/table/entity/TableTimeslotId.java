package com.restaurant.table.entity;

import java.io.Serializable;

public class TableTimeslotId implements Serializable {

    private String day;
    private String date_time;
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

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }
}
