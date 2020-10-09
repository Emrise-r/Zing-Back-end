package com.example.zingfakebackend.service.user;

import com.example.zingfakebackend.model.User;

public interface IUserService {
      User saveUser(User user);

      void deleteUser(Long id);

      Iterable<User> findAllUser();

      User findUserById(Long id);

      User findUserByEmail(String email);

      Iterable<User> findUserByName(String input);

      Iterable<User> findByUserName(String userName);

      boolean emailExist(String email);
}
