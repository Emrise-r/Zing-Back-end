package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
      User findUserByEmail(String email);
      Iterable<User> findAllByNameContaining(String inputData);
      Optional<User> findByName(String name);
      Optional<User> findByEmail(String email);
      Boolean existsByName(String name);
      Boolean existsByEmail(String email);
}
