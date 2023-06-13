package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Basket;
import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
