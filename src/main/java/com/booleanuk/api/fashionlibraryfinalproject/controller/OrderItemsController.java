package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import com.booleanuk.api.fashionlibraryfinalproject.model.OrderItem;
import com.booleanuk.api.fashionlibraryfinalproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class OrderItemsController {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/orderitems")
    public List<OrderItem> getAll() {
        return this.orderItemRepository.findAll();
    }

    @GetMapping("/orderitems/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable int id) {
        OrderItem orderItem = null;
        orderItem = this.orderItemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order item with this id is not found."));
        return ResponseEntity.ok(orderItem);
    }

    @PostMapping("items/{item_id}/orders/{order_id}")
    public ResponseEntity<OrderItem> createItemOrderItem(@RequestBody OrderItem orderItem, @PathVariable ("itemId") int itemId, @PathVariable("orderId") int orderId) {
        Item tempItem = this.itemRepository.findById(itemId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not create order item if item id is not found"));
        orderItem.setItem(tempItem);
        Order tempOrder = this.orderRepository.findById(orderId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not create order item if order is not found."));
        orderItem.setOrder(tempOrder);

        LocalDateTime createdAt = LocalDateTime.now();
        orderItem.setCreatedAt(createdAt);
        orderItem.setUpdatedAt(createdAt);
        return new ResponseEntity<OrderItem>(this.orderItemRepository.save(orderItem), HttpStatus.CREATED);
    }


}
