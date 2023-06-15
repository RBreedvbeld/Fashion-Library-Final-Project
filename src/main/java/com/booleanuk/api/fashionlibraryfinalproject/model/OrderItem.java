package com.booleanuk.api.fashionlibraryfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
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

    @ManyToOne
    @JoinColumn(name =  "item_id", referencedColumnName = "id")
//    @JsonIgnoreProperties("orderItem")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "amount_item(s)")
    private int amountItem;
    @Column(name = "total_credit_price_p/d")
    private double totalPricePerDay;

    @Column(name = "total_price_to_buy")
    private double totalPriceToBuy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // constructors
    public OrderItem() {
        super();
    }

    public OrderItem(int amountItem, double totalPricePerDay, double totalPriceToBuy, LocalDateTime updatedAt, Order order, Item item) {
        this.amountItem = amountItem;
        this.totalPricePerDay = totalPricePerDay;
        this.totalPriceToBuy = totalPriceToBuy;
        this.updatedAt = updatedAt;
        this.order = order;
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", amountItem=" + amountItem +
                ", totalPricePerDay=" + totalPricePerDay +
                ", totalPriceToBuy=" + totalPriceToBuy +
                ", updatedAt=" + updatedAt +
                ", order=" + order +
                ", item=" + item +
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

    public double getTotalPricePerDay() {
        return totalPricePerDay;
    }

    public void setTotalPricePerDay(double totalPricePerDay) {
        this.totalPricePerDay = totalPricePerDay;
    }

    public double getTotalPriceToBuy() {
        return totalPriceToBuy;
    }

    public void setTotalPriceToBuy(double totalPriceToBuy) {
        this.totalPriceToBuy = totalPriceToBuy;
    }

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
}
