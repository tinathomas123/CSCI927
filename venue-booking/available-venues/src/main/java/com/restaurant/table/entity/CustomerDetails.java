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

    @Column(name = "selectedVenue")
    private String selectedVenue;

    @Column(name = "bookedDateTime")
    private String bookedDateTime;

    @Column(name = "bookingConfirmationId")
    private String bookingConfirmationId;

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

    public String getSelectedVenue() {
        return selectedVenue;
    }

    public void setSelectedVenue(String selectedVenue) {
        this.selectedVenue = selectedVenue;
    }

    public String getBookedDateTime() {
        return bookedDateTime;
    }

    public void setBookedDateTime(String bookedDateTime) {
        this.bookedDateTime = bookedDateTime;
    }

    public String getBookingConfirmationId() {
        return bookingConfirmationId;
    }

    public void setBookingConfirmationId(String bookingConfirmationId) {
        this.bookingConfirmationId = bookingConfirmationId;
    }
}
