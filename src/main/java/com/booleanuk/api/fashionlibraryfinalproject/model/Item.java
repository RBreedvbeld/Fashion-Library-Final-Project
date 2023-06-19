package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private String title;
//    private String itemType;
//    private String brand;
//    private String size;


//    @ManyToOne
//    @JoinColumn(name = "orderItem_id", referencedColumnName = "id")
//    @JsonIgnoreProperties("items")
//    private OrderItem orderItem;

    @OneToMany(mappedBy = "item")
//    @JsonIgnoreProperties("item")
    @JsonIgnoreProperties(value = {"title", "item_type", "brand", "available_sizes"})
    private List<OrderItem> orderItems;
    @OneToMany(mappedBy = "item")
    @JsonIgnoreProperties("item")
    private List<BorrowedItem> listBorrowedItems;

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
    @Column(name = "credits_per_day")
    private String creditsPerDay;
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

    // TODO removed OrderItem orderItem from constructor because commented out in fields

    // Added lists to constructor


    public Item(String title, String itemType, String brand, String size, String availableSizes, String itemStatus, String creditsPerDay, double priceToBuy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.itemType = itemType;
        this.brand = brand;
        this.size = size;
        this.availableSizes = availableSizes;
        this.itemStatus = itemStatus;
        this.creditsPerDay = creditsPerDay;
        this.priceToBuy = priceToBuy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime setCreatedAt(LocalDateTime createdAt
    ) {
        return this.createdAt = createdAt;
    }

    // toString method
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                ", listBorrowedItems=" + listBorrowedItems +
                ", title='" + title + '\'' +
                ", itemType='" + itemType + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", availableSizes='" + availableSizes + '\'' +
                ", itemStatus='" + itemStatus + '\'' +
                ", creditsPerDay='" + creditsPerDay + '\'' +
                ", priceToBuy=" + priceToBuy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
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
        return this.availableSizes;
    }

    public void setAvailableSizes(String availableSizes) {
        this.availableSizes = availableSizes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getPricePerDay() {
        return this.creditsPerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.creditsPerDay = pricePerDay;
    }

    public double getPriceToBuy() {
        return this.priceToBuy;
    }

    public void setPriceToBuy(double priceToBuy) {
        this.priceToBuy = priceToBuy;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
//
//    public List<BorrowedItem> getListBorrowedItems() {
//        return listBorrowedItems;
//    }
//
//    public void setListBorrowedItems(List<BorrowedItem> listBorrowedItems) {
//        this.listBorrowedItems = listBorrowedItems;
//    }

    public String getCreditsPerDay() {
        return creditsPerDay;
    }

    public void setCreditsPerDay(String creditsPerDay) {
        this.creditsPerDay = creditsPerDay;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
