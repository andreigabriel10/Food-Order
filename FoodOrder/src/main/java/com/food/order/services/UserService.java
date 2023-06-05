package com.food.order.services;

import com.food.order.models.dto.UserDTO;
import com.food.order.models.entities.User;
import com.food.order.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        User createdUser = userRepository.save(user);

        return new UserDTO(createdUser.getUserId(), createdUser.getUsername(), createdUser.getEmail());
    }

    public UserDTO getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(user -> new UserDTO(user.getUserId(), user.getUsername(), user.getEmail()))
                .orElse(null);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());

            User updatedUser = userRepository.save(user);

            return new UserDTO(updatedUser.getUserId(), updatedUser.getUsername(), updatedUser.getEmail());
        }).orElse(null);
    }

    public boolean deleteUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}