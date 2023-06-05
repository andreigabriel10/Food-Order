package com.food.order.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestaurantDTO {

    @NotNull(message = "Restaurant ID cannot be null")
    private Long restaurantId;

    @NotNull(message = "Restaurant name cannot be null")
    @Size(min = 1, max = 100, message = "Restaurant name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Restaurant address cannot be null")
    private String address;

    public RestaurantDTO(Long restaurantId, String name, String address) {
    }
}
