package com.booleanuk.api.fashionlibraryfinalproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "title")
    private String title;
    @Column(name = "item_type")
    private String itemType;
    @Column(name = "brand")
    private String brand;
    @Column(name = "size")
    private String size;
    @Column(name = "available_sizes")
    private String availableSizes;

// TODO: I want to make itemStatus a function, because the system can see if the 'Size' is available as an option in the 'availableSizes'
    @Column(name = "item_status")
    private String itemStatus;
    @Column(name = "price_per_day")
    private String pricePerDay;
    @Column(name = "price_to_buy")
    private double priceToBuy;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    private Item(){
        super();
    }

    public Item(String title, String brand, String size, String itemStatus, String pricePerDay, double priceToBuy) {
        this.title = title;
        this.brand = brand;
        this.size = size;
        this.itemStatus = itemStatus;
        this.pricePerDay = pricePerDay;
        this.priceToBuy = priceToBuy;
//        this.updatedAt = updatedAt;
        LocalDateTime createdAt = LocalDateTime.now();
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(createdAt);
    }

    public LocalDateTime setCreatedAt(LocalDateTime createdAt
    ) {
        return this.createdAt = createdAt;
    }

    // getter- and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(String availableSizes) {
        this.availableSizes = availableSizes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPriceToBuy() {
        return priceToBuy;
    }

    public void setPriceToBuy(double priceToBuy) {
        this.priceToBuy = priceToBuy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
