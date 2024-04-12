package com.example.loginauthapi.dto;

import com.example.loginauthapi.enums.UserRole;

public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
