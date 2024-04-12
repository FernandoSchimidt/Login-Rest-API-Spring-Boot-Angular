package com.fernandoschimidt.car_rentel.dto;

import com.fernandoschimidt.car_rentel.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private UserRole userRole;
    private Long userId;
}
