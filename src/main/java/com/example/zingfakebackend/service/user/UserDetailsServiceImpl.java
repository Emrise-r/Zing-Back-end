package com.example.zingfakebackend.service.user;

import com.example.zingfakebackend.model.User;
import com.example.zingfakebackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

      @Autowired
      IUserRepository userRepository;

      @Override
      @Transactional
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + username));
            return UserDetailsImpl.build(user);
      }
}
