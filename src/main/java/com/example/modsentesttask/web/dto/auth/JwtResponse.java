package com.example.modsentesttask.web.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    Long id;
    String username;
    String accessToken;
    String refreshToken;

}
