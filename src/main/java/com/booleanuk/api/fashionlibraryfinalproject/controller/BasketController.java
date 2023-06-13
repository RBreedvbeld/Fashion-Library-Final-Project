package com.booleanuk.api.fashionlibraryfinalproject.controller;

import com.booleanuk.api.fashionlibraryfinalproject.model.Basket;
import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import com.booleanuk.api.fashionlibraryfinalproject.repository.BasketRepository;
import com.booleanuk.api.fashionlibraryfinalproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @GetMapping
    public List<Basket> getAll() {
        return this.basketRepository.findAll();
    }
}
