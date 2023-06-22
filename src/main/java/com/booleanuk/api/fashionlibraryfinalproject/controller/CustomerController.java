package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
import com.booleanuk.api.fashionlibraryfinalproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    // TODO: find out why .findALL() method does not work?!
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        LocalDateTime createdAt = LocalDateTime.now();
        customer.setCreatedAt(createdAt);
        customer.setUpdatedAt(createdAt);
        return new ResponseEntity<Customer>(this.customerRepository.save(customer), HttpStatus.CREATED);
    }
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
