package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
