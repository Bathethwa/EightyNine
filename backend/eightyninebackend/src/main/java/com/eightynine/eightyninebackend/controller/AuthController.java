package com.eightynine.eightyninebackend.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eightynine.eightyninebackend.dto.UserDTO;
import com.eightynine.eightyninebackend.model.User;
import com.eightynine.eightyninebackend.repository.UserRepository;
import com.eightynine.eightyninebackend.service.JwtService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;

    private UserRepository repository;

    public AuthController(UserRepository repository ) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO request){

        try {
            Authentication auth = authManager.authenticate(
                
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            System.out.println("Authentication successful: " + auth.getName());
            String jwt = jwtService.generateToken(request.getEmail());
            Optional<User> user = this.repository.findByEmail(request.getEmail());
                         
            return ResponseEntity.ok(Map.of("token",jwt,
                                            "user",user) );
        } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }


}



}