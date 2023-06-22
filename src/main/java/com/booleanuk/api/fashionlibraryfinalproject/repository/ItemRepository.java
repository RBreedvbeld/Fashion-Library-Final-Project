package com.booleanuk.api.fashionlibraryfinalproject.repository;

import com.booleanuk.api.fashionlibraryfinalproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

//    public static List<Item> getItemByTitle(String title) {
//        List<Item> getItemByTitle = ItemRepository.getItemByTitle(title);
//        return getItemByTitle;
//    }

    List<Item> findByTitleIgnoreCase(String title);
    List<Item> findByItemTypeIgnoreCase(String itemType);
    List<Item> findItemByBrandIgnoreCase(String brand);
    List<Item> findItemBySizeIgnoreCase(String size);
    List<Item> findItemByCreditsPerDayIgnoreCase(String creditsPerDay);
    List<Item> findByPriceToBuyBetween(double minPriceToBuy, double maxPriceToBuy);
    List<Item> findByAvailableSizesIgnoreCase(String availableSizes);

}
