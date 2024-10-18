package com.restaurant.table.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class CustomerDetails
{
    @Column(name = "customerName")
    private String customerName;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "selectedTable")
    private String selectedTable;

    @Column(name = "reservedDateTime")
    private String reservedDateTime;

    @Column(name = "reservationConfirmationId")
    private String reservationConfirmationId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }

    public String getReservedDateTime() {
        return reservedDateTime;
    }

    public void setReservedDateTime(String reservedDateTime) {
        this.reservedDateTime = reservedDateTime;
    }

    public String getReservationConfirmationId() {
        return reservationConfirmationId;
    }

    public void setReservationConfirmationId(String reservationConfirmationId) {
        this.reservationConfirmationId = reservationConfirmationId;
    }
}
