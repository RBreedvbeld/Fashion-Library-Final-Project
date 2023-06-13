package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.UserDetails;
import com.booleanuk.api.fashionlibraryfinalproject.repository.UserDetailsRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userRepository;

// DONE, check if <User> has the right reference!
    @GetMapping
    public List<UserDetails> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable int id) {
        UserDetails userDetails = null;
        userDetails = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User details with this id is not found."));
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
        LocalDateTime createdAt = LocalDateTime.now();
        userDetails.setItemBorrowedAt(createdAt);
        userDetails.setUpdatedAt(createdAt);
        return new ResponseEntity<UserDetails>(this.userRepository.save(userDetails), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetails> updateUserDetails(@PathVariable int id, @RequestBody UserDetails userDetails) {
        UserDetails userDetailsToUpdate = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update user details, as id is not found!"));

        userDetailsToUpdate.setFirstName(userDetails.getFirstName());
        userDetailsToUpdate.setLastName(userDetails.getLastName());
        userDetailsToUpdate.setAddress(userDetails.getAddress());
        userDetailsToUpdate.setEmail(userDetails.getEmail());
        userDetailsToUpdate.setPhone(userDetails.getPhone());
        userDetailsToUpdate.setBorrowedItems(userDetails.getBorrowedItems());
        userDetailsToUpdate.setBoughtItems(userDetails.getBoughtItems());
        userDetailsToUpdate.setCustomerOrMember(userDetails.getCustomerOrMember());

        LocalDateTime createdAt = LocalDateTime.now();
        userDetailsToUpdate.setUpdatedAt(LocalDateTime.now());
//        userDetailsToUpdate.setUpdatedAt(LocalDateTime.now());
        return new ResponseEntity<UserDetails>(this.userRepository.save(userDetailsToUpdate), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDetails> deleteUserDetails(@PathVariable int id) {
        UserDetails userDetailsToDelete = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not delete user details, as id is not found!"));
        this.userRepository.delete(userDetailsToDelete);
        return ResponseEntity.ok(userDetailsToDelete);
    }




}
