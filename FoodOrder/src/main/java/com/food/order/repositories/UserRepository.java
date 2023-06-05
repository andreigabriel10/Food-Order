package com.food.order.repositories;


import com.food.order.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM users")
    Long countUsers();
}
