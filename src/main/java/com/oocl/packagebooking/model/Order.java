package com.oocl.packagebooking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private long startTime;

    public Order(String recipient, String phone, int status, long startTime) {
        this.recipient = recipient;
        this.phone = phone;
        this.status = status;
        this.startTime = startTime;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}

