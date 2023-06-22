package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.*;
import com.booleanuk.api.fashionlibraryfinalproject.repository.BorrowedItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BorrowedItemRepository borrowedItemRepository;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

// DONE, check if <User> has the right reference!
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = null;
        user = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this id is not found."));
        return ResponseEntity.ok(user);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LocalDateTime createdAt = LocalDateTime.now();
        user.setItemBorrowedAt(createdAt);
//        user.setUpdatedAt(createdAt);
        return new ResponseEntity<User>(this.userRepository.save(user), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user) {
        User userToUpdate = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update user details, as id is not found!"));

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setBorrowedItems(user.getBorrowedItems());
        userToUpdate.setBoughtItems(user.getBoughtItems());
        // TODO: Check getCustomer
        LocalDateTime createdAt = LocalDateTime.now();
        userToUpdate.setUpdatedAt(LocalDateTime.now());
        return new ResponseEntity<User>(this.userRepository.save(userToUpdate), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserDetails(@PathVariable int id) {
        User userToDelete = this.userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not delete user details, as id is not found!"));
        this.userRepository.delete(userToDelete);
        return ResponseEntity.ok(userToDelete);
    }




}
