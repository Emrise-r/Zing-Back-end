package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.ERole;
import com.example.zingfakebackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
      Optional<Role> findByName(ERole name);
}
