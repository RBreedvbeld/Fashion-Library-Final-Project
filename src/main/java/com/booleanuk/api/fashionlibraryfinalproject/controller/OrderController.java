package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired

    @GetMapping
    public List<Order> getAllPublishers() {
        return this.orderRepository.findAll();
    }

}
