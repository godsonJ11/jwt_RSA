package com.asymmetricKey.jwt.dto;

import com.asymmetricKey.jwt.model.TOKEN_TYPE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDto {
    private String accessToken;
    private String userName;
    private int expiry_time;
    private TOKEN_TYPE tokenType;
}
