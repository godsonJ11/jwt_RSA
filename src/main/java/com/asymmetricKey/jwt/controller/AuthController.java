package com.asymmetricKey.jwt.controller;

import com.asymmetricKey.jwt.dto.AuthRequest;
import com.asymmetricKey.jwt.dto.AuthResponseDto;
import com.asymmetricKey.jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/sign-in")
    public ResponseEntity<?> singIn(@RequestBody AuthRequest authRequest){
        AuthResponseDto authResponseDto=authService.generateAccessToken(authRequest);
        return ResponseEntity.ok(authResponseDto);
    }
}
