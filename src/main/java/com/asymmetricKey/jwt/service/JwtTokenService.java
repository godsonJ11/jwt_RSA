package com.asymmetricKey.jwt.service;

import com.asymmetricKey.jwt.dto.AuthRequest;
import com.asymmetricKey.jwt.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtTokenService {

private final JwtEncoder jwtEncoder;
    public String generateJwtToken(Users authRequest) {
        JwtClaimsSet jwtClaimsSet= JwtClaimsSet
                .builder()
                .issuer("godson")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(15, ChronoUnit.MINUTES))
                .subject(authRequest.getName())
                .claim("role",authRequest.getAuthorities())
                .build();
return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }
}
