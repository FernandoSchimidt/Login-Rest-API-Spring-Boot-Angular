package com.fernandoschimidt.car_rentel.dto;

import com.fernandoschimidt.car_rentel.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private UserRole userRole;
}
