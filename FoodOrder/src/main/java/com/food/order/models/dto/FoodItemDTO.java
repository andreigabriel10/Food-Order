package com.food.order.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodItemDTO {
    private Long id;

    @NotBlank(message = "Food name is required")
    private String name;

    @NotBlank(message = "Food description is required")
    private String description;

    @NotNull(message = "Food price is required")
    private BigDecimal price;
}
