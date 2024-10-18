package com.restaurant.table.repository;

import com.restaurant.table.entity.EventVenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventVenueRepository extends JpaRepository<EventVenue, String> {

    List<EventVenue> findByStatus(String available);
}
