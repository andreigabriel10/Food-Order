package com.food.order.services;

import com.food.order.models.dto.RestaurantDTO;
import com.food.order.models.entities.Restaurant;
import com.food.order.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());

        Restaurant createdRestaurant = restaurantRepository.save(restaurant);

        return new RestaurantDTO(createdRestaurant.getRestaurantId(), createdRestaurant.getName(), createdRestaurant.getAddress());
    }

    public RestaurantDTO getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> new RestaurantDTO(restaurant.getRestaurantId(), restaurant.getName(), restaurant.getAddress()))
                .orElse(null);
    }

    public RestaurantDTO updateRestaurant(Long restaurantId, RestaurantDTO restaurantDTO) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurant.setName(restaurantDTO.getName());
            restaurant.setAddress(restaurantDTO.getAddress());

            Restaurant updatedRestaurant = restaurantRepository.save(restaurant);

            return new RestaurantDTO(updatedRestaurant.getRestaurantId(), updatedRestaurant.getName(), updatedRestaurant.getAddress());
        }).orElse(null);
    }

    public boolean deleteRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurantRepository.delete(restaurant);
            return true;
        }).orElse(false);
    }
}
