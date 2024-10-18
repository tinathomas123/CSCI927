package com.table.timeslot.repository;

import com.table.timeslot.entity.TableTimeslot;
import com.table.timeslot.entity.TableTimeslotId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableTimeslotRepository extends JpaRepository<TableTimeslot, TableTimeslotId> {

    List<TableTimeslot> findBySelectedTable(String selectedTable);
}
