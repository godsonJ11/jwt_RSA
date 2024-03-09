package com.asymmetricKey.jwt.dto;

import lombok.Data;
import org.springframework.security.core.Authentication;


@Data
public class AuthRequest {
    private String name;
    private String password;
}
