package com.example.loginauthapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Sucesso");
    }
}
