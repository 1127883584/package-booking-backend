package com.oocl.packagebooking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "booking_order")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    private String recipient;

    private String phone;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private long pickupTime;

    public Order(String orderNumber, String recipient, String phone, int status, long pickupTime) {
        this.orderNumber = orderNumber;
        this.recipient = recipient;
        this.phone = phone;
        this.status = status;
        this.pickupTime = pickupTime;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}

