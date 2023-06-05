package com.food.order.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MenuDTO {

    @NotNull(message = "Menu ID cannot be null")
    private Long menuId;

    @NotNull(message = "Menu name cannot be null")
    @Size(min = 1, max = 100, message = "Menu name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Menu price cannot be null")
    private double price;
}
