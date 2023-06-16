package com.booleanuk.api.fashionlibraryfinalproject.repository;


import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
//import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import com.booleanuk.api.fashionlibraryfinalproject.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
//    void deleteByOrder(Order order);
    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByOrderId(int order_id);
}
