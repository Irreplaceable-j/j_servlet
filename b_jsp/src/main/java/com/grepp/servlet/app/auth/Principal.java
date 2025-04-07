package com.grepp.servlet.app.auth;

import java.time.LocalDateTime;
import java.util.List;

public record Principal (
    String userId,
    List<Role> role,
    LocalDateTime loginedAt
){

    public static final Principal ANONYMOUS
        = new Principal("anonymous", List.of(Role.ROLE_ANONYMOUS), LocalDateTime.now());

}

