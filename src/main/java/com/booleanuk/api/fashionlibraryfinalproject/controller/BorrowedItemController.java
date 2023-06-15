package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.BorrowedItem;
import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.repository.BorrowedItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class BorrowedItemController {

    @Autowired
    private BorrowedItemRepository borrowedItemRepository;

    //TODO: Check if @Autowired are the right ones!!
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<BorrowedItem> getAllPublishers() {
        return this.borrowedItemRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<BorrowedItem> getBorrowedItemById(@PathVariable int id) {
        // TODO: Check why this is  null!
        BorrowedItem borrowedItem = null;
        // TODO: Add start_time from borrowed_item!
        borrowedItem = this.borrowedItemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found borrowed item, as id is not found!"));
        return ResponseEntity.ok(borrowedItem);
    }

//    ("items/{id}/borroweditems")
    @PostMapping("borroweditems")
    public ResponseEntity<BorrowedItem> createBorrowedItem(@RequestBody BorrowedItem borrowedItem, @PathVariable int id) {
        Item tempItem = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't create a borrowed item as item id not found"));

        LocalDateTime createdAt = LocalDateTime.now();
        borrowedItem.setStartBorrowDateAt(createdAt);
        borrowedItem.setEndBorrowDateAt(createdAt);
        return new ResponseEntity<BorrowedItem>(this.borrowedItemRepository.save(borrowedItem), HttpStatus.CREATED);
    }


}
