package com.restaurant.table.service;

import com.restaurant.table.entity.RestaurantTable;
import com.restaurant.table.repository.RestaurantTableRepository;
import com.restaurant.table.response.RestaurantTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class RestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepo;

    @Autowired
    private ModelMapper mapper;

    public List<RestaurantTable> getAvailableTables()
    {
        return tableRepo.findByStatus("Available");
    }
}
