package com.example.zingfakebackend.service.user;

import com.example.zingfakebackend.model.User;
import com.example.zingfakebackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

      @Autowired
      private IUserRepository userRepository;

      @Override
      public User saveUser(User user) {
            userRepository.save(user);
            return userRepository.findById(user.getUserId()).get();
      }

      @Override
      public void deleteUser(Long id) {
            userRepository.deleteById(id);
      }

      @Override
      public Iterable<User> findAllUsers() {
            return userRepository.findAll();
      }

      @Override
      public User findUserById(Long id) {
            return userRepository.findById(id).get();
      }

      @Override
      public User findUserByEmail(String email) {
            return userRepository.findUserByEmail(email);
      }

      @Override
      public Iterable<User> findUserByName(String input) {
            return userRepository.findAllByNameContaining(input);
      }

      @Override
      public Optional<User> findByUserName(String userName) {
            return userRepository.findByName(userName);
      }

      @Override
      public boolean emailExist(String email) {
            return userRepository.existsByEmail(email);
      }
}
