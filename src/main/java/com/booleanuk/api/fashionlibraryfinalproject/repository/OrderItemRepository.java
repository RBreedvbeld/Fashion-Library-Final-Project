package com.booleanuk.api.fashionlibraryfinalproject.repository;


import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
//import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
