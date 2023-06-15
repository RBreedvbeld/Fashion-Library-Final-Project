package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowed_items")
public class BorrowedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"phone", "email", "customer_or_member"})
    private User user;
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @JsonIncludeProperties(value = {"title", "size", "price_per_day", "price_to_buy"})
    private Item item;

    @Column(name = "quantity_item")
    private int quantityItem;

    // TODO: use these startBorrowDateAt() and endBorrowDateAt() for calculating days that item has been borrowed!
    @Column(name = "start_borrow_date")
    @CreationTimestamp
    private LocalDateTime startBorrowDateAt;
    @Column(name = "end_borrow_date")
    @UpdateTimestamp
    private LocalDateTime endBorrowDateAt;

    // TODO: show in column if item is bought or borrowed!

// constructors

    public BorrowedItem(){

    }

    // TODO HAve a look at the constructors, maybe need a Setter constructor?
    // TODO removed String itemSize out of constructor arguments
    public BorrowedItem(User user, Item item, int quantityItem, LocalDateTime startBorrowDateAt, LocalDateTime endBorrowDateAt) {
        this.user = user;
        this.item = item;
        this.quantityItem = quantityItem;
//        this.itemSize = itemSize;
        this.startBorrowDateAt = startBorrowDateAt;
        this.endBorrowDateAt = endBorrowDateAt;
    }

    // toString method
    @Override
    public String toString() {
        return "BorrowedItem{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", quantityItem=" + quantityItem +
//                ", itemSize='" + itemSize + '\'' +
                ", startBorrowDateAt=" + startBorrowDateAt +
                ", endBorrowDateAt=" + endBorrowDateAt +
                '}';
    }

    // getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

//    public String getItemSize() {
//        return itemSize;
//    }
//
//    public void setItemSize(String itemSize) {
//        this.itemSize = itemSize;
//    }

    public LocalDateTime getStartBorrowDateAt() {
        return startBorrowDateAt;
    }

    public void setStartBorrowDateAt(LocalDateTime startBorrowDateAt) {
        this.startBorrowDateAt = startBorrowDateAt;
    }

    public LocalDateTime getEndBorrowDateAt() {
        return endBorrowDateAt;
    }

    public void setEndBorrowDateAt(LocalDateTime endBorrowDateAt) {
        this.endBorrowDateAt = endBorrowDateAt;
    }
}