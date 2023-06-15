package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.OrderItem;
import com.booleanuk.api.fashionlibraryfinalproject.repository.*;
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
@RequestMapping("/orderitems")
public class OrderItemsController {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<OrderItem> getAll() {
        return this.orderItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable int id) {
        OrderItem orderItem = null;
        orderItem = this.orderItemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order item with this id is not found."));
        return ResponseEntity.ok(orderItem);
    }

}
