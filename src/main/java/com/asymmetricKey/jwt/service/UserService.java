package com.asymmetricKey.jwt.service;

import com.asymmetricKey.jwt.dto.UserDTO;
import com.asymmetricKey.jwt.model.Role;
import com.asymmetricKey.jwt.model.Users;
import com.asymmetricKey.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public String storeUserDetails(UserDTO userDTO) {
        userRepository.save(Users.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(Role.ROLE_USER)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build());
        return "success";
    }
}
