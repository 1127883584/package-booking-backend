package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.model.Order;
import com.oocl.packagebooking.repository.OrderRepository;
import com.oocl.packagebooking.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Transactional
    public void should_return_the_new_order_when_add_a_new_order() throws Exception {
        Order orderOne = new Order(1, 1000L);
        given(orderService.createOrder(any(Order.class))).willReturn(orderOne);

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(orderOne)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1));
    }

    @Test
    @Transactional
    public void should_return_all_the_orders_when_query_orders() throws Exception {
        List<Order> orderList = new ArrayList<>();
        Order orderOne = new Order(1, 1000L);
        orderList.add(orderOne);
        given(orderService.getAllOrders()).willReturn(orderList);

        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].status").value(1))
                .andExpect(jsonPath("$.[0].pickupTime").value(1000L));
    }

    @Test
    @Transactional
    public void should_return_the_updated_order_when_storage_order_by_id() throws Exception {
        Order orderOne = new Order(1, 1000L);
        given(orderService.updateOrderById(any(Order.class))).willReturn(orderOne);
        mockMvc.perform(put("/orders/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(orderOne)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1));
    }

    @Test
    @Transactional
    public void should_return_the_updated_order_when_storage_order_by_order_number() throws Exception {
        Order orderOne = new Order(1, 1000L);
        given(orderService.updateOrderByOrderNumber(any(Order.class))).willReturn(orderOne);
        mockMvc.perform(put("/orders?orderNumber=201907240001")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(orderOne)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1));
    }

}