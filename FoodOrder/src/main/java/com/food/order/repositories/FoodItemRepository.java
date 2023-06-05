package com.food.order.repositories;

import com.food.order.models.entities.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemEntity, Long> {

    @Query
    FoodItemEntity findFoodItemByName(String name);
}
