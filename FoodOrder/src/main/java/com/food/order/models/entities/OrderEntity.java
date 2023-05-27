package com.food.order.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToMany
    @JoinTable(name = "order_food_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id"))
    private List<FoodItemEntity> foodItems;

    private BigDecimal total;

}
