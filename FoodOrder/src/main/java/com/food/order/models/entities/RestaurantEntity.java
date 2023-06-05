package com.food.order.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "restaurant_name")})
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "restaurant_name")
    private String name;
    @Column(name = "restaurant_address")
    private String address;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<FoodItemEntity> foodItems;
}
