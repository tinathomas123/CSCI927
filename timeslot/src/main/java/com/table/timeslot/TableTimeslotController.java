package com.table.timeslot;

import com.table.timeslot.entity.TableTimeslot;
import com.table.timeslot.request.TableTimeslotRequest;
import com.table.timeslot.response.TableTimeslotListResponse;
import com.table.timeslot.service.TableTimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TableTimeslotController {

    @Autowired
    TableTimeslotService tableTimeslotService;

    @ResponseBody
    @PostMapping("/get-timeslots")
    public TableTimeslotListResponse getTimeSlotsForSelectedTable(@RequestBody TableTimeslotRequest timeslotRequest, Model model)
    {
        TableTimeslotListResponse response=new TableTimeslotListResponse();
        if(timeslotRequest!=null) {
            return tableTimeslotService.getTimeslotsForSelectedTable(timeslotRequest.getSelectedTable());
        }
        return response;
    }
}
