package com.mvet.presidency.auth.service;

import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.admin.repository.UserRepository;
import com.mvet.presidency.auth.dto.AuthResponse;
import com.mvet.presidency.auth.dto.LoginRequest;
import com.mvet.presidency.common.exception.BusinessException;
import com.mvet.presidency.config.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmailIgnoreCase(request.email())
                .orElseThrow(() -> new BusinessException("Identifiants invalides"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BusinessException("Identifiants invalides");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                "Bearer",
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                user.getEmail(),
                user.getRole() != null && user.getRole().getName() != null
                        ? user.getRole().getName().name()
                        : "ROLE_USER"
        );
    }
}