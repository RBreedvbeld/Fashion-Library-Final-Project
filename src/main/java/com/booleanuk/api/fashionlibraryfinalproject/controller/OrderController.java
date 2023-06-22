package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.*;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = null;
        order = this.orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with this id is not found."));
        return ResponseEntity.ok(order);
    }

    public record OrderRequest(int customerId, int[] itemIds){}
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {

        Customer tempCustomer = this.customerRepository.findById(orderRequest.customerId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found customer."));
        List<Item> items = Arrays.stream(orderRequest.itemIds).mapToObj(id -> {
            return itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find the item id."));
        }).toList();
        Order order = new Order();
        order.setCustomer(tempCustomer);
        order.setCreateAt(LocalDateTime.now());
        orderRepository.save(order);

        List<OrderItem> orderItems = items.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(item);
            orderItem.setAmountItem(1);
            return orderItem;
        }).toList();
        orderItemRepository.saveAll(orderItems);
        return new ResponseEntity<Order>(this.orderRepository.save(order), HttpStatus.CREATED);
    }

//    public record OrderRequest(int customerId, int[] itemIds){}
    @CrossOrigin(origins = "*")
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") int orderId, @RequestBody OrderRequest orderRequest) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find the order."));

        Customer tempCustomer = customerRepository.findById(orderRequest.customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find the customer."));

        List<Item> items = Arrays.stream(orderRequest.itemIds)
                .mapToObj(id -> itemRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find the item with this id.")))
                .toList();
        order.setCustomer(tempCustomer);
        order.setUpdatedAt(LocalDateTime.now());

//        orderItemRepository.deleteByOrder(order);
        // TODO: Find a solution to not completely delete the list of order items but only the one that not matches the existing ones.
        List<OrderItem> removeOrderItems = orderItemRepository.findByOrderId(orderId);
        orderItemRepository.deleteAllInBatch(removeOrderItems);

        List<OrderItem> orderItems = items.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(item);
            orderItem.setAmountItem(0);
            return orderItem;
        }).toList();

        orderItemRepository.saveAll(orderItems);

        return new ResponseEntity<Order>(orderRepository.save(order), HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable ("orderId") int orderId) {
        Order orderToDelete = this.orderRepository.findById(orderId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't delete as id not found"));
         List<OrderItem> orderItems = orderItemRepository.findByOrder(orderToDelete);


//        orderItemRepository.deleteAll(orderItems);
        this.orderRepository.delete(orderToDelete);
        return ResponseEntity.ok(orderToDelete);
    }



}
