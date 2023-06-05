package com.food.order.models.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class FoodItemDTO implements Serializable {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 100, message = "Food item name should contain between 2 and 100 characters.")
    private String name;

    @NotNull
    @DecimalMin(value = "0.0", message = "Minimum price can't be 0.0.")
    private double price;

    @NotNull
    @Min(value = 0, message = "The inventory number should be 0 or more. 0 means it's out of stock")
    private int inventory;

    @NotNull
    @NotEmpty
    @Size(max = 500, message = "Description should contain no more than 500 characters.")
    private String description;

    @NotNull
    @Min(value = 1, message = "Preparation time should be at least 1 minute.")
    private int preparationTime;

    @NotNull
    @NotEmpty
    private String category;
}
