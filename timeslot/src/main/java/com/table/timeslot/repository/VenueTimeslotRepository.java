package com.table.timeslot.repository;

import com.table.timeslot.entity.VenueTimeslot;
import com.table.timeslot.entity.VenueTimeslotId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueTimeslotRepository extends JpaRepository<VenueTimeslot, VenueTimeslotId> {

    List<VenueTimeslot> findBySelectedVenue(String selectedVenue);
}
