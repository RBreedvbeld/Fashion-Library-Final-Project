package com.booleanuk.api.fashionlibraryfinalproject.repository;


import com.booleanuk.api.fashionlibraryfinalproject.model.Account;
import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
