package com.example.loginauthapi.dto;

import com.example.loginauthapi.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private UserRole userRole;
}
