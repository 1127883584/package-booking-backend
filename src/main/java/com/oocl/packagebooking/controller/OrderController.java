package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Order;
import com.oocl.packagebooking.repository.OrderRepository;
import com.oocl.packagebooking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8083/")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity createOrders(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        if (newOrder != null){
            return ResponseEntity.ok(newOrder);
        }
        return ResponseEntity.ok("order is exception");
    }

    @GetMapping("/orders")
    public ResponseEntity getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity updateOrdersById(@PathVariable int id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrderById(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @PutMapping("/orders")
    public ResponseEntity updateOrdersByOrderNumber(@RequestParam String orderNumber, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrderByOrderNumber(order);
        return ResponseEntity.ok(updatedOrder);
    }
}

