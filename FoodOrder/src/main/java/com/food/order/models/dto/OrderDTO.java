package com.food.order.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

    @NotNull
    private Long userId;

    @NotNull
    @NotEmpty
    private List<Long> foodItemIds;

    @NotNull
    @NotEmpty
    private String deliveryAddress;

    @NotNull
    private String phoneNumber;
}
