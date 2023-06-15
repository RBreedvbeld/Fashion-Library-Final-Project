package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
//    @JsonIncludeProperties(value = {"order_date"})
    private List<Order> listOrder;
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Order order;

    @Column(name = "item_name")
    private String itemName;
    @Column(name = "category")
    private String category;
    // TODO: daysBorrowed() method that counts the days from start_date till end_date!!
    @Column(name = "days_borrowed")
    private String daysBorrowed;
    @Column(name = "payment_method")
    private String paymentMethod;
    // TODO: If cardNumber = null, than paymendMethod = 'Cash'
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "item_borrowed_at")
    @CreationTimestamp
    private LocalDateTime itemBorrowedAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    public Customer(int id) {
       super();
    }
    public Customer(){
    }
//    public List<Customer> customers;

    public Customer(String itemName, String category, String daysBorrowed, String paymentMethod, String cardNumber, LocalDateTime itemBorrowedAt, LocalDateTime updatedAt) {
        this.itemName = itemName;
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
        return this.itemName;
    }

    public void setTitle(String title) {
        this.itemName = title;
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


    public void setUser(User tempUser) {
    }
}
