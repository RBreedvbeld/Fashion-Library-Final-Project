package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // TODO Commented out @JsonIgnoreProperties Order from @ManyToOne
    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn (name = "customer_id", referencedColumnName = "id")
//    @JsonIgnoreProperties("order")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    // TODO
//    @JsonIgnoreProperties("order")
    @JsonIncludeProperties(value = {"item_name", "category", "order_date" })
    private List<OrderItem> orderItems;

    @Column(name = "item_name")
    private String itemName;
    @Column(name = "category")
    private String category;
    @Column (name = "order_date")
    @CreationTimestamp
    private LocalDateTime createAt;
    @Column (name = "update_order_date")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order() {
    }
    public Order(int id) {
        this.id = id;
    }


    public Order(Customer customer, List<OrderItem> orderItems, String itemName, String category, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.itemName = itemName;
        this.category = category;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }


    // if you need to print something to the console then use toString


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderItems=" + orderItems +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public String getItemName() {
        return this.itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreateAt() {
        return this.createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
