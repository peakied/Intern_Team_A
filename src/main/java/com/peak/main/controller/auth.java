package com.peak.main.controller;


import com.peak.security.model.AuthenticationRequest;
import com.peak.security.service.AuthenticationService;
import com.peak.security.model.RegisterRequest;
import com.peak.main.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class auth {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest request) {
        if (request.getName() == null || request.getEmail() == null || request.getPassword() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new Response(service.register(request)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthenticationRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new Response(service.authenticate(request)));
    }
}
