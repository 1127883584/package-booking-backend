package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
