package com.example.loginauthapi.services.auth;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.RegisterRegisterDTO;
import com.example.loginauthapi.dto.UserDto;
import com.example.loginauthapi.enums.UserRole;
import com.example.loginauthapi.repositories.UserReposioty;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final UserReposioty userReposioty;

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userReposioty.findByUserRole(UserRole.ADMIN);
        if (adminAccount == null) {
            User newAdminAccount = new User();
            newAdminAccount.setName("Admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.ADMIN);
            userReposioty.save(newAdminAccount);
            System.out.println("Admin account create successfully");
        }
    }


    public UserDto createCustomer(RegisterRegisterDTO registerRegisterDTO) {
        User user = new User();
        user.setName(registerRegisterDTO.getName());
        user.setEmail(registerRegisterDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRegisterDTO.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userReposioty.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }


    public boolean hasCustomerWithEmail(String email) {
        return userReposioty.findByEmail(email).isPresent();
    }
}
