package com.songdi.paas.auth.server.service;

import com.songdi.paas.auth.server.util.user.JwtAuthenticationRequest;

public interface AuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;

    String refresh(String oldToken) throws Exception;

    void validate(String token) throws Exception;
}
