package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Customer;
import com.booleanuk.api.fashionlibraryfinalproject.model.OrderItem;
import com.booleanuk.api.fashionlibraryfinalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    List<Customer> getUserByCustomerId(int user_id);
}
