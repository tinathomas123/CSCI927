package com.table.timeslot.service;

import com.table.timeslot.entity.BookingDate;
import com.table.timeslot.repository.BookingDateRepository;
import com.table.timeslot.response.BookingDateListResponse;
import com.table.timeslot.response.BookingDateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookingDateService {

    @Autowired
    private BookingDateRepository tableRepo;

    @Autowired
    private ModelMapper mapper;

    public BookingDateListResponse getAvailableDatesForSelectedRoom(String selectedRoom)
    {
        BookingDateListResponse bookingDateListResponse=new BookingDateListResponse();
        List<BookingDateResponse> bookingDateResponses=new ArrayList<>();
        List<BookingDate> availableDates= tableRepo.findBySelectedRoom(selectedRoom);
        for(BookingDate availableDate: availableDates)
        {
            BookingDateResponse bookingDateResponse=new BookingDateResponse();
            bookingDateResponse.setDate(availableDate.getDate().toString());
            bookingDateResponse.setDay(availableDate.getDay());
            bookingDateResponse.setSelectedRoom(availableDate.getSelectedRoom());
            bookingDateResponses.add(bookingDateResponse);
        }
        bookingDateListResponse.setAvailableDates(bookingDateResponses);
        return bookingDateListResponse;
    }
}
