package com.food.order.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "food_items")
public class FoodItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "category")
    private String category;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "food_items_orders", joinColumns = @JoinColumn(name = "food_item_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<OrderEntity> orders = new HashSet<>();
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "nutrition_info")
    private String nutritionInfo;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "special_notes")
    private String specialNotes;
}
