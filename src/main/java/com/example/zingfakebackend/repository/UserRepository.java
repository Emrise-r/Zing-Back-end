package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
