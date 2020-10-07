package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
