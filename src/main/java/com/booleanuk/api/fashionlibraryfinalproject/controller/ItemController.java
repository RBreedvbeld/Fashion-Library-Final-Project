package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.UserDetailsRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Item item = null;
        item = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with this id is not found."));
        return ResponseEntity.ok(item);
    }

    // TODO: @GetMapping by Type, Brand, Size, Availability and ItemStatus
//    @GetMapping("{itemType}")
//    public ResponseEntity<Item> getItemByType(@PathVariable String itemType) {
//        Item item = null;
//        item = this.itemRepository.findAll(item).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with this id is not found."));
//        return ResponseEntity.ok(item);
//    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        LocalDateTime createdAt = LocalDateTime.now();
        item.setCreatedAt(createdAt);
        item.setUpdatedAt(createdAt);
        return new ResponseEntity<Item>(this.itemRepository.save(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
        Item itemToUpdate = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update item, as id is not found!"));

        itemToUpdate.setTitle(item.getTitle());
        itemToUpdate.setItemType(item.getItemType());
        itemToUpdate.setBrand(item.getBrand());
        itemToUpdate.setSize(item.getSize());
        itemToUpdate.setAvailableSizes(item.getAvailableSizes());
        itemToUpdate.setItemStatus(item.getItemStatus());
        itemToUpdate.setPricePerDay(item.getPricePerDay());
        itemToUpdate.setPriceToBuy(item.getPriceToBuy());

        LocalDateTime createdAt = LocalDateTime.now();
        itemToUpdate.setUpdatedAt(LocalDateTime.now());
//        itemToUpdate.setUpdatedAt(LocalDateTime.now());
        return new ResponseEntity<Item>(this.itemRepository.save(itemToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item itemToDelete = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not delete item, as id is not found!"));
        this.itemRepository.delete(itemToDelete);
        return ResponseEntity.ok(itemToDelete);
    }
}
