package com.mvet.presidency.auth.controller;

import com.mvet.presidency.auth.dto.AuthResponse;
import com.mvet.presidency.auth.dto.LoginRequest;
import com.mvet.presidency.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
