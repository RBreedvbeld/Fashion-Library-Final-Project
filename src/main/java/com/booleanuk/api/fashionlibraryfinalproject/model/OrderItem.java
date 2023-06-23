package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_items")
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name =  "item_id", referencedColumnName = "id")
    @JsonIncludeProperties(value = {"title", "item_type", "brand", "size", "credits_per_day", "price_to_buy"})
//    @JsonIgnoreProperties("orderItem")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "order")
//    @JsonIncludeProperties(value = {"item_name", "category"})
    private Order order;

    @Column(name = "amount_item")
    private int amountItem;
//    @Column(name = "total_credits_per_day")
//    private double totalPricePerDay;
//
//    @Column(name = "total_price_to_buy")
//    private double totalPriceToBuy;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    public OrderItem() {
        super();
    }

    public OrderItem(int amountItem, double totalPricePerDay, double totalPriceToBuy, LocalDateTime updatedAt, Order order, Item item, byte[] photo) {
        this.amountItem = amountItem;
//        this.totalPricePerDay = totalPricePerDay;
//        this.totalPriceToBuy = totalPriceToBuy;
        this.updatedAt = updatedAt;
        this.order = order;
        this.item = item;
        this.photo= photo;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", item=" + item +
                ", order=" + order +
                ", amountItem=" + amountItem +
//                ", totalPricePerDay=" + totalPricePerDay +
//                ", totalPriceToBuy=" + totalPriceToBuy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountItem() {
        return amountItem;
    }

    public void setAmountItem(int amountItem) {
        this.amountItem = amountItem;
    }

//    public double getTotalPricePerDay() {
//        return totalPricePerDay;
//    }
//
//    public void setTotalPricePerDay(double totalPricePerDay) {
//        this.totalPricePerDay = totalPricePerDay;
//    }
//
//    public double getTotalPriceToBuy() {
//        return totalPriceToBuy;
//    }
//
//    public void setTotalPriceToBuy(double totalPriceToBuy) {
//        this.totalPriceToBuy = totalPriceToBuy;
//    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
