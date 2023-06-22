package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "borrowedItem_id", referencedColumnName = "id")
    @JsonIncludeProperties(value = {""})
    private BorrowedItem borrowedItem;

    // TODO: Check if this @OneTo?Many is necessary?!
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("user")
    @JsonIncludeProperties(value = {"first_name", "last_name"})
    private List<BorrowedItem> listBorrowedItems;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "borrowed_items")
    private int numBorrowedItems;
    @Column(name = "bought_items")
    private String boughtItems;

    // TODO: Find out how to write java for implementing if-statements for if user exists = true = member if not, casual user!
    // TODO remove item_borrowed_at, because this is double data
    @Column(name = "item_borrowed_at")
    @CreationTimestamp
    private LocalDateTime itemBorrowedAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    //, boolean customer, boolean member
    public User(String firstName, String lastName, String address, String email, String phone, int numBorrowedItems, String boughtItems, LocalDateTime itemBorrowedAt, LocalDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.numBorrowedItems = numBorrowedItems;
        this.boughtItems = boughtItems;
        this.itemBorrowedAt = itemBorrowedAt;
        this.updatedAt = updatedAt;
    }

    // toString method

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", numBorrowedItems=" + numBorrowedItems +
                ", boughtItems='" + boughtItems + '\'' +
                ", itemBorrowedAt=" + itemBorrowedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    // getter and setters

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBoughtItems() {
        return this.boughtItems;
    }
    public void setBoughtItems(String boughtItems) {
        this.boughtItems = boughtItems;
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
        return this.numBorrowedItems;
    }
    public void setBorrowedItems(int borrowedItems) {
        this.numBorrowedItems = borrowedItems;
    }
    public List<BorrowedItem> getListBorrowedItems() {
        return this.listBorrowedItems;
    }
    public BorrowedItem getBorrowedItem() {
        return this.borrowedItem;
    }
    public void setBorrowedItem(BorrowedItem borrowedItem) {
        this.borrowedItem = borrowedItem;
    }
    public void setListBorrowedItems(List<BorrowedItem> listBorrowedItems) {
        this.listBorrowedItems = listBorrowedItems;
    }
    public int getNumBorrowedItems() {
        return this.numBorrowedItems;
    }
    public void setNumBorrowedItems(int numBorrowedItems) {
        this.numBorrowedItems = numBorrowedItems;
    }
    public void setCustomer(Customer tempCustomer) {
    }
}
