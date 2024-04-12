package com.fernandoschimidt.car_rentel.services.auth;

import com.fernandoschimidt.car_rentel.dto.SignupRequest;
import com.fernandoschimidt.car_rentel.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
