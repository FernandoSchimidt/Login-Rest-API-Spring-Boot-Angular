package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.LoginRequestDTO;
import com.example.loginauthapi.dto.RegisterRegisterDTO;
import com.example.loginauthapi.dto.ResponseDTO;
import com.example.loginauthapi.infra.security.TokenService;
import com.example.loginauthapi.repositories.UserReposioty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final UserReposioty reposioty;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {

        User user = this.reposioty.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(),user.getName(), token,user.getUserRole()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRegisterDTO body) {
        Optional<User> user = this.reposioty.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUSer = new User();
            newUSer.setPassword(passwordEncoder.encode(body.password()));
            newUSer.setEmail(body.email());
            newUSer.setName(body.name());
            newUSer.setUserRole(body.userRole());
            this.reposioty.save(newUSer);

            String token = this.tokenService.generateToken(newUSer);
            return ResponseEntity.ok(new ResponseDTO(newUSer.getEmail(),newUSer.getName(), token,newUSer.getUserRole()));
        }
        return ResponseEntity.badRequest().build();
    }
}
