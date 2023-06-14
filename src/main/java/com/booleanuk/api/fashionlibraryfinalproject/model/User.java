package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "borrowed_id", referencedColumnName = "id")
    private BorrowedItem borrowedItem;

    // TODO: Check if this @OneTo?Many is necessary?!
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("user")
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
    private int borrowedItems;
    @Column(name = "bought_items")
    private String boughtItems;

    // TODO: Find out how to write java for implementing if-statements for if user exists = true = member if not, casual user!
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

    // constructors
    public User(int id) {
        this.id = id;
    }
    public User() {
    }

    public User(String firstName, String lastName, String address, String email, String phone, int borrowedItems, String boughtItems, String customerOrMember, LocalDateTime itemBorrowedAt, LocalDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.borrowedItems = borrowedItems;
        this.boughtItems = boughtItems;
        this.customerOrMember = customerOrMember;
        this.itemBorrowedAt = itemBorrowedAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", customer=" + customer +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", borrowedItems=" + borrowedItems +
                ", boughtItems='" + boughtItems + '\'' +
                ", customerOrMember='" + customerOrMember + '\'' +
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

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

//    public String getCustomerOrMember() {
//        return this.customerOrMember;
//    }
//
//    public void setCustomerOrMember(String customerOrMember) {
//        this.customerOrMember = customerOrMember;
//    }
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer tempCustomer) {
    }


}
