package com.restaurant.table.response;

import com.restaurant.table.entity.TableTimeslot;

import java.util.List;

public class RestaurantTableResponse {

    private List<TableTimeslotResponse> timeslotList;

    public List<TableTimeslotResponse> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<TableTimeslotResponse> timeslotList) {
        this.timeslotList = timeslotList;
    }
}
