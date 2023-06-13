package com.booleanuk.api.fashionlibraryfinalproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item")
    private String item;

    @Column(name = "amount_item(s)")
    private int amountItem;
    @Column(name = "total_credit_price_p/d")
    private double totalPricePerDay;

    @Column(name = "total_price_to_buy")
    private double totalPriceToBuy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Basket () {
        super();
    }


    public Basket(String item, int amountItem, double totalPricePerDay, double totalPriceToBuy, LocalDateTime updatedAt) {
        this.item = item;
        this.amountItem = amountItem;
        this.totalPricePerDay = totalPricePerDay;
        this.totalPriceToBuy = totalPriceToBuy;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountItem() {
        return this.amountItem;
    }

    public void setAmountItem(int amountItem) {
        this.amountItem = amountItem;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public double getTotalPricePerDay() {
        return this.totalPricePerDay;
    }

    public void setTotalPricePerDay(double totalPricePerDay) {
        this.totalPricePerDay = totalPricePerDay;
    }

    public double getTotalPriceToBuy() {
        return this.totalPriceToBuy;
    }

    public void setTotalPriceToBuy(double totalPriceToBuy) {
        this.totalPriceToBuy = totalPriceToBuy;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
