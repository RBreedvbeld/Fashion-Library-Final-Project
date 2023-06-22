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
    @JsonIncludeProperties(value = {"title", "size", "brand", "price_per_day", "price_to_buy"})
    private Item item;

    @Column(name = "quantity_item")
    private int quantityItem;

    // TODO: use these startBorrowDateAt() and endBorrowDateAt() for calculating days that item has been borrowed!
    @Column(name = "start_borrow_date")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "end_borrow_date")
    @UpdateTimestamp
    private LocalDateTime endedAt;

    // TODO: show in column if item is bought or borrowed!

// constructors
    public BorrowedItem(){
    }

    // TODO HAve a look at the constructors, maybe need a Setter constructor?
    // TODO removed String itemSize out of constructor arguments
    public BorrowedItem(User user, Item item, int quantityItem, LocalDateTime createdAt, LocalDateTime endedAt) {
        this.user = user;
        this.item = item;
        this.quantityItem = quantityItem;
//        this.itemSize = itemSize;
        this.createdAt = createdAt;
        this.endedAt = endedAt;
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
                ", createdAt=" + createdAt +
                ", endedAt=" + endedAt +
                '}';
    }

    // getter and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantityItem() {
        return this.quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public LocalDateTime getStartBorrowDateAt() {
        return this.createdAt;
    }

    public void setStartBorrowDateAt(LocalDateTime startBorrowDateAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndBorrowDateAt() {
        return this.endedAt;
    }

    public void setEndBorrowDateAt(LocalDateTime endBorrowDateAt) {
        this.endedAt = endedAt;
    }
}
