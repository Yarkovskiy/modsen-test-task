package com.example.modsentesttask.service;

import com.example.modsentesttask.web.dto.auth.JwtRequest;
import com.example.modsentesttask.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
