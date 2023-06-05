package com.food.order.services;

import com.food.order.models.dto.OrderDTO;
import com.food.order.models.entities.Menu;
import com.food.order.models.entities.Order;
import com.food.order.models.entities.Restaurant;
import com.food.order.models.entities.User;
import com.food.order.repositories.MenuRepository;
import com.food.order.repositories.OrderRepository;
import com.food.order.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, UserService userService,
                        RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        User user = userService.getUserById(orderDTO.getUserId());
        Restaurant restaurant = restaurantRepository.findById(orderDTO.getRestaurantId()).orElse(null);
        List<Menu> menus = menuRepository.findAllById(orderDTO.getMenuIds());

        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setMenus(menus);
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setOrderDate(orderDTO.getOrderDate());

        Order createdOrder = orderRepository.save(order);

        return new OrderDTO(createdOrder.getOrderId(), createdOrder.getUser(),
                createdOrder.getRestaurant(), createdOrder.getMenus(),
                createdOrder.getTotalAmount(), createdOrder.getOrderDate());
    }

    public OrderDTO getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(order -> new OrderDTO(order.getOrderId(), order.getUser(), order.getRestaurant(), order.getMenus(), order.getTotalAmount(), order.getOrderDate()))
                .orElse(null);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        return orderRepository.findById(orderId).map(order -> {
            order.setUser(userRepository.findById(orderDTO.getUserId()).orElse(null));
            order.setRestaurant(restaurantRepository.findById(orderDTO.getRestaurantId()).orElse(null));
            order.setMenus(menuRepository.findAllById(orderDTO.getMenuIds()));
            order.setTotalAmount(orderDTO.getTotalAmount());
            order.setOrderDate(orderDTO.getOrderDate());

            Order updatedOrder = orderRepository.save(order);

            return new OrderDTO(updatedOrder.getOrderId(), updatedOrder.getUser(), updatedOrder.getRestaurant(), updatedOrder.getMenus(), updatedOrder.getTotalAmount(), updatedOrder.getOrderDate());
        }).orElse(null);
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        return orderRepository.findById(orderId).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }
}
