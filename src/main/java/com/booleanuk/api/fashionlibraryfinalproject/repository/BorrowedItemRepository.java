package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.BorrowedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedItemRepository extends JpaRepository<BorrowedItem, Integer> {
}
