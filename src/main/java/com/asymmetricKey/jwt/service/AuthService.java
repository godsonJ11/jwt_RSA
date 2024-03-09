package com.asymmetricKey.jwt.service;

import com.asymmetricKey.jwt.dto.AuthRequest;
import com.asymmetricKey.jwt.dto.AuthResponseDto;
import com.asymmetricKey.jwt.model.TOKEN_TYPE;
import com.asymmetricKey.jwt.model.Users;
import com.asymmetricKey.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    public AuthResponseDto generateAccessToken(AuthRequest authRequest) {
        AuthResponseDto authResponseDto = new AuthResponseDto();
        try {
            Users users = userRepository.findByName(authRequest.getName()).orElseThrow(() -> {
                log.error("INVALID USER:{}", authRequest.getName());
                return new ResponseStatusException(HttpStatus.NOT_FOUND);
            });
            String access_token = jwtTokenService.generateJwtToken(users);
            authResponseDto.setExpiry_time(1);
            authResponseDto.setTokenType(TOKEN_TYPE.Bearer);
            authResponseDto.setAccessToken(access_token);
            authResponseDto.setUserName(users.getName());

        } catch (Exception ex) {
            log.error("[AUTHENTICATION-ERROR]{}", authRequest.getPassword());
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return authResponseDto;
    }
}
