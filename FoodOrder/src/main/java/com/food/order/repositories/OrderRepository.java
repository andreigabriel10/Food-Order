package com.food.order.repositories;

import com.food.order.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Add any custom query methods if needed

    @Query("SELECT o FROM Order o WHERE o.user.username = :username")
    List<Order> findByUserUsername(@Param("username") String username);
}
