package com.table.timeslot.repository;

import com.table.timeslot.entity.BookingDate;
import com.table.timeslot.entity.BookingDateId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDateRepository extends JpaRepository<BookingDate, BookingDateId> {

    List<BookingDate> findBySelectedRoom(String selectedRoom);
}
