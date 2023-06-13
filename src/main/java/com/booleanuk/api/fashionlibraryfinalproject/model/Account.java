package com.booleanuk.api.fashionlibraryfinalproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "days_borrowed")
    private String daysBorrowed;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "card_number")
    private String cardNumber;



    @Column(name = "item_borrowed_at")
    @CreationTimestamp
    private LocalDateTime itemBorrowedAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Account(int id) {
       super();
    }

    public Account(String title, String category, String daysBorrowed, String paymentMethod, String cardNumber, LocalDateTime itemBorrowedAt, LocalDateTime updatedAt) {
        this.title = title;
        this.category = category;
        this.daysBorrowed = daysBorrowed;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.itemBorrowedAt = itemBorrowedAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDaysBorrowed() {
        return this.daysBorrowed;
    }

    public void setDaysBorrowed(String daysBorrowed) {
        this.daysBorrowed = daysBorrowed;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
}
