package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
}
