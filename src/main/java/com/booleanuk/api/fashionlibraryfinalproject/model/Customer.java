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

    // TODO: daysBorrowed() method that counts the days from start_date till end_date!!
    @Column(name = "payment_method")
    private String paymentMethod;
    // TODO: If cardNumber = null, than paymendMethod = 'Cash'
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    public Customer(int id) {
       super();
    }
    public Customer(){
    }
    public Customer(String paymentMethod, String cardNumber, LocalDateTime updatedAt) {
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.updatedAt = updatedAt;
    }
//    public List<Customer> customers;

// toString
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", listOrder=" + listOrder +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
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

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUser(User tempUser) {
    }
}
