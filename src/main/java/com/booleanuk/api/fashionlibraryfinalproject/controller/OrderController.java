package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.BorrowedItem;
import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired

    @GetMapping("/orders")
    public List<Order> getAllPublishers() {
        return this.orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = null;
        order = this.orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with this id is not found."));
        return ResponseEntity.ok(order);
    }

    @PostMapping("/customers{customer_id}/orders/{order_id}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, @PathVariable int id) {
        Customer tempCustomer = this.customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't create order as item id not found"));
        order.setCustomer(tempCustomer);

        LocalDateTime createdAt = LocalDateTime.now();
        order.setOrderDateAt(createdAt);
        order.setUpdateOrderDateAt(createdAt);
        return new ResponseEntity<Order>(this.orderRepository.save(order), HttpStatus.CREATED);
    }




}
