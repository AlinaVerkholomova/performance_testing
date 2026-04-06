package com.example.demo.rest;


import com.example.demo.security.JwtUtil;
import com.example.demo.security.LoginRequest;
import com.example.demo.security.LoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if (!"admin".equals(request.getUsername()) || !"admin".equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(request.getUsername());
        return new LoginResponse(token);
    }
}