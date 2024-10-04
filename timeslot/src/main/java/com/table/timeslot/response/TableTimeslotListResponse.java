package com.table.timeslot.response;

import com.table.timeslot.entity.TableTimeslot;

import java.util.List;

public class TableTimeslotListResponse {

    private List<TableTimeslotResponse> timeslotList;

    public List<TableTimeslotResponse> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<TableTimeslotResponse> timeslotList) {
        this.timeslotList = timeslotList;
    }

}
