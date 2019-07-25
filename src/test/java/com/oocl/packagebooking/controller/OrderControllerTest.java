package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.repository.OrderRepository;
import com.oocl.packagebooking.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //    @MockBean
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    @Transactional
    public void should_return_the_new_order_when_add_a_new_order() throws Exception {
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"orderNumber\": \"201907240002\",\n" +
                        "    \"pickupTime\": 1564019566295\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNumber").value("201907240002"));
    }

    @Test
    @Transactional
    public void should_all_the_orders_when_query_orders() throws Exception {
        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"orderNumber\": \"201907240001\",\n" +
                        "        \"recipient\": null,\n" +
                        "        \"phone\": null,\n" +
                        "        \"status\": 1,\n" +
                        "        \"pickupTime\": 1564019566295\n" +
                        "    }\n" +
                        "]"));
    }

}