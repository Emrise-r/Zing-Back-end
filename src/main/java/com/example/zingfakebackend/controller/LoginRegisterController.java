package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.config.security.JwtProvider;
import com.example.zingfakebackend.model.ERole;
import com.example.zingfakebackend.model.RefreshToken;
import com.example.zingfakebackend.model.Role;
import com.example.zingfakebackend.model.User;
import com.example.zingfakebackend.model.payload.request.LoginRequest;
import com.example.zingfakebackend.model.payload.request.RefreshTokenRequest;
import com.example.zingfakebackend.model.payload.request.RegisterRequest;
import com.example.zingfakebackend.model.payload.response.JwtResponse;
import com.example.zingfakebackend.repository.IRoleRepository;
import com.example.zingfakebackend.repository.IUserRepository;
import com.example.zingfakebackend.repository.f5token.RefreshTokenService;
import com.example.zingfakebackend.service.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 7200)
@RequestMapping("/api/auth")
public class LoginRegisterController {
      @Autowired
      AuthenticationManager authenticationManager;

      @Autowired
      IUserRepository userRepository;

      @Autowired
      IRoleRepository roleRepository;

      @Autowired
      PasswordEncoder encoder;

      @Autowired
      JwtProvider jwtProvider;

      @Autowired
      private RefreshTokenService refreshTokenService;

      @PostMapping("/login")
      public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles;
            roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setToken(jwt);
            refreshTokenService.generateRefreshToken(refreshToken);
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles));

      }

      @PostMapping("/register")
      public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
            if (userRepository.existsByName(registerRequest.getName())) {
                  return new ResponseEntity<>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
            }
            if (userRepository.existsByEmail(registerRequest.getName())) {
                  return new ResponseEntity<>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
            }

            User user = new User(registerRequest.getName(),
                    registerRequest.getEmail(), encoder.encode(registerRequest.getPassword()));

            Set<String> strRoles = registerRequest.getRole();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                  Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                  roles.add(userRole);
            } else {
                  strRoles.forEach(role -> {
                        if ("admin".equals(role)) {
                              Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                      .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                              roles.add(adminRole);
                        } else {
                              Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                      .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                              roles.add(userRole);
                        }
                  });
            }

            user.setRoles(roles);
            userRepository.save(user);
            return ResponseEntity.ok().body("User register successfully!");
      }

      @PostMapping("/logout")
      public ResponseEntity<?> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
            refreshTokenService.deleteRefreshToken(refreshTokenRequest.getToken());
            return ResponseEntity.ok().body("Bye!");
      }

      @GetMapping("/test")
      public ResponseEntity<?> tset(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest, HttpSecurity httpSecurity, Authentication auth) {
            auth.getPrincipal();
            return ResponseEntity.ok().body("Bye!");
      }
}
