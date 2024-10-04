package com.restaurant.table.service;

import com.restaurant.table.entity.HotelRoom;
import com.restaurant.table.repository.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.List;

public class RoomBookingService {

    @Autowired
    private RoomBookingRepository roomBookingRepo;

    @Autowired
    private ModelMapper mapper;

    public List<HotelRoom> getAvailableTables()
    {
        return roomBookingRepo.findByStatus("Available");
    }
}
