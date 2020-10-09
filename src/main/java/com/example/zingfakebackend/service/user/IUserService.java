package com.example.zingfakebackend.service.user;

import com.example.zingfakebackend.model.User;

import java.util.Optional;

public interface IUserService {
      User saveUser(User user);

      void deleteUser(Long id);

      Iterable<User> findAllUsers();

      User findUserById(Long id);

      User findUserByEmail(String email);

      Iterable<User> findUserByName(String input);

      Optional<User> findByUserName(String userName);

      boolean emailExist(String email);
}
