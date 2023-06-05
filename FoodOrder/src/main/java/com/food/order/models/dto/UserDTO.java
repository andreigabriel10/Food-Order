package com.food.order.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Username cannot be null")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    public UserDTO(Long userId, String username, String email) {
    }
}
