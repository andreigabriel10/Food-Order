package com.food.order.services;

import com.food.order.models.dto.FoodItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodItemService {

    FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO);

    List<FoodItemDTO> getFoodItems();

    FoodItemDTO updateFoodItemById(Long id, FoodItemDTO foodItemDTO);

    void deleteFoodItemById(Long id);

    FoodItemDTO getFoodItemsByName(String name);
}
