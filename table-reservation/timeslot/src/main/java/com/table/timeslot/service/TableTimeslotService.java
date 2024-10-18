package com.table.timeslot.service;

import com.table.timeslot.entity.TableTimeslot;
import com.table.timeslot.repository.TableTimeslotRepository;
import com.table.timeslot.response.TableTimeslotListResponse;
import com.table.timeslot.response.TableTimeslotResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TableTimeslotService {

    @Autowired
    private TableTimeslotRepository tableRepo;

    @Autowired
    private ModelMapper mapper;

    public TableTimeslotListResponse getTimeslotsForSelectedTable(String selectedTable)
    {
        TableTimeslotListResponse tableTimeslotListResponse=new TableTimeslotListResponse();
        List<TableTimeslotResponse> timeslotResponses=new ArrayList<>();
        List<TableTimeslot> timeslotList= tableRepo.findBySelectedTable(selectedTable);
        for(TableTimeslot timeslot: timeslotList)
        {
            TableTimeslotResponse timeslotResponse=new TableTimeslotResponse();
            timeslotResponse.setDateTime(timeslot.getDate_time().toString());
            timeslotResponse.setDay(timeslot.getDay());
            timeslotResponse.setSelectedTable(timeslot.getSelectedTable());
            timeslotResponses.add(timeslotResponse);
        }
        tableTimeslotListResponse.setTimeslotList(timeslotResponses);
        return tableTimeslotListResponse;
    }
}
