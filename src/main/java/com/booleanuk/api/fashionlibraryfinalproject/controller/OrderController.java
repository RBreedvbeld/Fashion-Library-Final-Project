package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = null;
        order = this.orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with this id is not found."));
        return ResponseEntity.ok(order);
    }


}
