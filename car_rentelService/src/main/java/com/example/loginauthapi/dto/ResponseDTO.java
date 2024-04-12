package com.example.loginauthapi.dto;

import com.example.loginauthapi.enums.UserRole;

public record ResponseDTO(String email, String name, String token, UserRole userRole) {
}
