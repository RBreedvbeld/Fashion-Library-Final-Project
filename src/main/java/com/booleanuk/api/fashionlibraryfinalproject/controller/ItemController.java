package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.repository.CustomerRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Item item = null;
        item = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with this id is not found."));
        return ResponseEntity.ok(item);
    }

    // TODO: @GetMapping by Title, Type, Brand, Size, (Availability and ItemStatus)
    @CrossOrigin(origins = "*")
    @GetMapping("/title/{title}")
    public List<Item> getItemsByTitle(@PathVariable String title) {
        return itemRepository.findByTitleIgnoreCase(title);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/itemtype/{itemType}")
    public List<Item> getItemsByItemType(@PathVariable String itemType) {
        return itemRepository.findByItemTypeIgnoreCase(itemType);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/brand/{brand}")
    public List<Item> getItemsByBrand(@PathVariable String brand) {
        return itemRepository.findItemByBrandIgnoreCase(brand);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/size/{size}")
    public List<Item> getItemsBySize(@PathVariable String size) {
        return itemRepository.findItemBySizeIgnoreCase(size);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/creditsperday/{creditsPerDay}")
    public List<Item> getItemsByCreditsPerDay(@PathVariable String creditsPerDay) {
        return itemRepository.findItemByCreditsPerDayIgnoreCase(creditsPerDay);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/pricetobuy/{priceToBuy}")
    public List<Item> getItemsByPriceRange(@RequestParam double minPriceToBuy, @RequestParam double maxPriceToBuy) {
        return itemRepository.findByPriceToBuyBetween(minPriceToBuy, maxPriceToBuy);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/availablesizes/{availableSizes}")
    public List<Item> getAvailableSizes(@PathVariable String availableSizes) {
        return itemRepository.findByAvailableSizesIgnoreCase(availableSizes);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/availablesizes")
    public ResponseEntity<List<String>> getAvailableSizes(@PathVariable int id) {
        Item item = itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with this id is not found."));

        List<String> availableSizes = Collections.singletonList(item.getAvailableSizes());
        return ResponseEntity.ok(availableSizes);
    }
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        LocalDateTime createdAt = LocalDateTime.now();
        item.setCreatedAt(createdAt);
        item.setUpdatedAt(createdAt);
        return new ResponseEntity<Item>(this.itemRepository.save(item), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
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
        itemToUpdate.setCreditsPerDay(item.getCreditsPerDay());
        itemToUpdate.setPriceToBuy(item.getPriceToBuy());

        LocalDateTime createdAt = LocalDateTime.now();
        itemToUpdate.setUpdatedAt(LocalDateTime.now());
//        itemToUpdate.setUpdatedAt(LocalDateTime.now());
        return new ResponseEntity<Item>(this.itemRepository.save(itemToUpdate), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item itemToDelete = this.itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not delete item, as id is not found!"));
        this.itemRepository.delete(itemToDelete);
        return ResponseEntity.ok(itemToDelete);
    }
}
