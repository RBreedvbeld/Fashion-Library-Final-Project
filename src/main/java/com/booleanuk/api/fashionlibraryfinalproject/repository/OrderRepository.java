package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
import com.booleanuk.api.fashionlibraryfinalproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    //    List<Order> getOrderByUserId(int user_id);
}
