package com.food.order.controllers;

import com.food.order.models.dto.FoodItemDTO;
import com.food.order.services.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class FoodItemController {
    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("admin/food-items")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody @Valid FoodItemDTO foodItemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodItemService.addFoodItem(foodItemDTO));
    }

    @GetMapping("admin/food-items")
    public List<FoodItemDTO> getMenuItems() {
        return foodItemService.getFoodItems();
    }

    @PutMapping("admin/food-items/{id}")
    public ResponseEntity<FoodItemDTO> updateFoodItemById(@PathVariable Long id, @RequestBody @Valid FoodItemDTO foodItemDTO) {
        return ResponseEntity.ok(foodItemService.updateFoodItemById(id, foodItemDTO));
    }

    @DeleteMapping("admin/food-items/{id}")
    public ResponseEntity<Void> deleteFoodItemById(@PathVariable Long id) {
        foodItemService.deleteFoodItemById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("food-items/{name}")
    public ResponseEntity<FoodItemDTO> getFoodItemByName(@PathVariable String name) {
        return ResponseEntity.ok(foodItemService.getFoodItemsByName(name));
    }
}
