package com.table.payment.repository;

import com.table.payment.entity.Payment;
import com.table.payment.entity.TableTimeslotId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, TableTimeslotId> {

    List<Payment> findBySelectedTable(String selectedTable);
}
