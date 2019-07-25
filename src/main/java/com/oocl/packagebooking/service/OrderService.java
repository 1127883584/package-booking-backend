package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Order;
import com.oocl.packagebooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        order.setStatus(1);
        Order newOrder = orderRepository.saveAndFlush(order);
        System.out.println(newOrder);
        return newOrder;
    }

    public Order updateOrderById(Order order){
        Order newOrder = orderRepository.saveAndFlush(order);
        System.out.println(newOrder);
        return newOrder;
    }

    public Order updateOrderByOrderNumber(Order order){
        Order orderTemp = orderRepository.findByOrderNumber(order.getOrderNumber());
        order.setId(orderTemp.getId());
        Order newOrder = orderRepository.saveAndFlush(order);
        System.out.println(newOrder.getOrderNumber());
        return newOrder;
    }
}
