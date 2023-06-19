package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
import com.booleanuk.api.fashionlibraryfinalproject.model.User;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    // TODO: find out why .findALL() method does not work?!
    @GetMapping
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    // TODO: Test to do it the other way around
//    @PostMapping("users/{id}/customers")
//    public ResponseEntity<Customer> createCustomerUser(@RequestBody Customer customer, @PathVariable int id) {
//        User tempUser = this.userRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not create User if customer is not found")); // TODO: not sure if this message is right.
//
//        customer.setUser(tempUser);
//        LocalDateTime createdAt = LocalDateTime.now();
//        customer.setItemBorrowedAt(createdAt);
//        customer.setUpdatedAt(createdAt);
//        return new ResponseEntity<Customer>(this.customerRepository.save(customer), HttpStatus.CREATED);
//    }
//    @GetMapping("users/{id}/customers")
//    public List<Customer> getAll(@PathVariable int user_id) {
//        List<Customer> customers = this.customerRepository.getUserByCustomerId(user_id);
//        return customers;
//    }
//    @GetMapping("customers/{id}/users")
//    public ResponseEntity<User> getUserById(@PathVariable int id) {
//        User user = null;
//        user = this.userRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND, "User details with this id is not found."));
//        return ResponseEntity.ok(user);
//    }

}
