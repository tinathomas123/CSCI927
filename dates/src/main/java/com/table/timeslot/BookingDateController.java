package com.table.timeslot;

import com.table.timeslot.request.BookingDateRequest;
import com.table.timeslot.response.BookingDateListResponse;
import com.table.timeslot.service.BookingDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookingDateController {

    @Autowired
    BookingDateService bookingDateService;

    @ResponseBody
    @PostMapping("/get-dates")
    public BookingDateListResponse getTimeSlotsForSelectedTable(@RequestBody BookingDateRequest bookingDateRequest, Model model)
    {
        BookingDateListResponse response=new BookingDateListResponse();
        if(bookingDateRequest!=null) {
            return bookingDateService.getAvailableDatesForSelectedRoom(bookingDateRequest.getSelectedRoom());
        }
        return response;
    }
}
