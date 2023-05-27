package com.food.order.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private String customerName;

    @NotNull
    @NotEmpty
    private List<Long> foodItemIds;
}
