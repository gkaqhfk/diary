package com.cbnu.diary.util;

import org.springframework.security.core.Authentication;

public abstract class AuthenticationUtils {

    private static final String ROLE_ADMIN_NAME = "ROLE_ADMIN";

    public static Boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(it -> it.getAuthority().equals(ROLE_ADMIN_NAME));
    }

}
