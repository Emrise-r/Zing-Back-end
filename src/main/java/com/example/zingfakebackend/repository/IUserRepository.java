package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
      User findUserByEmail(String email);
      Iterable<User> findAllByNameContaining(String inputData);
      Iterable<User> findByName(String name);
      Iterable<User> findByEmail(String email);
      Boolean existsByName(String name);
      Boolean existsByEmail(String email);
}
