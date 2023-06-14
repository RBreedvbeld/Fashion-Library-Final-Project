package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @Column (name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDateAt;

    @Column (name = "update_order_date")
    @UpdateTimestamp
    private LocalDateTime UpdateOrderDateAt;

    public Order(Customer customer, LocalDateTime orderDateAt, LocalDateTime updateOrderDateAt) {
        this.customer = customer;
        this.orderDateAt = orderDateAt;
        UpdateOrderDateAt = updateOrderDateAt;
    }

    // if you need to print something to the console then use toString
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDateAt=" + orderDateAt +
                ", UpdateOrderDateAt=" + UpdateOrderDateAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDateAt() {
        return orderDateAt;
    }

    public void setOrderDateAt(LocalDateTime orderDateAt) {
        this.orderDateAt = orderDateAt;
    }

    public LocalDateTime getUpdateOrderDateAt() {
        return UpdateOrderDateAt;
    }

    public void setUpdateOrderDateAt(LocalDateTime updateOrderDateAt) {
        UpdateOrderDateAt = updateOrderDateAt;
    }
}
