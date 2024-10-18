package com.restaurant.table.repository;

import com.restaurant.table.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomBookingRepository extends JpaRepository<HotelRoom, String> {

    List<HotelRoom> findByStatus(String available);
}
