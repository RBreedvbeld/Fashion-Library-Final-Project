package com.booleanuk.api.fashionlibraryfinalproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_details")
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "borrowed_items")
    private int borrowedItems;
    @Column(name = "bought_items")
    private String boughtItems;
    @Column(name = "customer_or_member")
    private String customerOrMember;
//    @Column(name = "member")
//    private boolean member;

    @Column(name = "item_borrowed_at")
    @CreationTimestamp
    private LocalDateTime itemBorrowedAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public UserDetails(int id) {
        super();
    }

    public UserDetails(String name, String address, String email, String phone, int borrowedItems, String boughtItems, String customerOrMember, LocalDateTime itemBorrowedAt, LocalDateTime updatedAt) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.borrowedItems = borrowedItems;
        this.boughtItems = boughtItems;
        this.customerOrMember = customerOrMember;
        this.itemBorrowedAt = itemBorrowedAt;
        this.updatedAt = updatedAt;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getItemBorrowedAt() {
        return this.itemBorrowedAt;
    }

    public void setItemBorrowedAt(LocalDateTime itemBorrowedAt) {
        this.itemBorrowedAt = itemBorrowedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getBorrowedItems() {
        return this.borrowedItems;
    }

    public void setBorrowedItems(int borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public String getBoughtItems() {
        return this.boughtItems;
    }

    public void setBoughtItems(String boughtItems) {
        this.boughtItems = boughtItems;
    }

    public String getCustomerOrMember() {
        return this.customerOrMember;
    }

    public void setCustomerOrMember(String customerOrMember) {
        this.customerOrMember = customerOrMember;
    }

}
