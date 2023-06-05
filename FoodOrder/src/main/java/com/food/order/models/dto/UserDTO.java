package com.food.order.models.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO implements Serializable {

    @NotNull(message = "Username is a mandatory field")
    @NotEmpty(message = "Username can't be empty")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotNull(message = "Email is a mandatory field")
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "Full name is a mandatory field")
    @NotEmpty(message = "Full name can't be empty")
    private String fullName;

    @Past(message = "Date of birth should be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Interests is a mandatory field")
    @NotEmpty(message = "Interests can't be empty")
    private List<String> interests;
}
