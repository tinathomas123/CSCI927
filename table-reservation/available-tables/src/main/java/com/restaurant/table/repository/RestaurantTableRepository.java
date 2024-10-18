package com.restaurant.table.repository;

import com.restaurant.table.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, String> {

    List<RestaurantTable> findByStatus(String available);
}
