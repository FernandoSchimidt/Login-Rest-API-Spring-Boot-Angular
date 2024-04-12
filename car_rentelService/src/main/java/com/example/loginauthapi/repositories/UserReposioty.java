package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposioty extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);

    User findByUserRole(UserRole userRole);
}
