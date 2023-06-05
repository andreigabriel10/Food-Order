package com.food.order.models.dto;

import com.food.order.models.entities.Menu;
import com.food.order.models.entities.Restaurant;
import com.food.order.models.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotNull(message = "User cannot be null")
    private UserDTO user;

    @NotNull(message = "Restaurant cannot be null")
    private RestaurantDTO restaurant;

    @NotNull(message = "Menus cannot be null")
    private List<MenuDTO> menus;

    @NotNull(message = "Total amount cannot be null")
    private double totalAmount;

    @NotNull(message = "Order date cannot be null")
    private LocalDate orderDate;

    public OrderDTO(Long orderId, User user, Restaurant restaurant, List<Menu> menus, double totalAmount, LocalDate orderDate) {
    }
}
