package com.food.order.services;

import com.food.order.models.dto.OrderDTO;
import com.food.order.models.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUserProfile(Long id, UserDTO userDTO);

    void deleteUserById(Long id);

    List<UserDTO> getUsers();

    UserDTO getUserById(Long id);

    OrderDTO createOrder(Long userId, OrderDTO orderDTO);
}