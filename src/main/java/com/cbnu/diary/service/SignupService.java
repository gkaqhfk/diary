package com.cbnu.diary.service;

import com.cbnu.diary.entity.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class SignupService {

    private static final String ROLE_INDIVIDUAL_NAME = "INDIVIDUAL";
    private static final String ROLE_CORPORATE_NAME = "CORPORATE";

    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Boolean createIndividual(UserRequest userRequest) {
        UserDetails individual = User.builder()
                .username(userRequest.getUsername())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .roles(ROLE_INDIVIDUAL_NAME)
                .build();
        jdbcUserDetailsManager.createUser(individual);
        return true;
    }

    @Transactional
    public Boolean createCorporate(UserRequest userRequest, MultipartFile file) {
        UserDetails corporate = User.builder()
                .username(userRequest.getUsername())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .disabled(true)
                .roles(ROLE_CORPORATE_NAME)
                .build();
        jdbcUserDetailsManager.createUser(corporate);
        return true;
    }

}
