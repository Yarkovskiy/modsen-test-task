package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.service.AuthService;
import com.example.modsentesttask.web.dto.auth.JwtRequest;
import com.example.modsentesttask.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
