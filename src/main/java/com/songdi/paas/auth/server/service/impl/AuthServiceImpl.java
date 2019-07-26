package com.songdi.paas.auth.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.songdi.paas.admin.rpc.UserRest;
import com.songdi.paas.api.vo.user.UserInfo;
import com.songdi.paas.auth.common.util.jwt.JWTInfo;
import com.songdi.paas.auth.server.service.AuthService;
import com.songdi.paas.auth.server.util.user.JwtAuthenticationRequest;
import com.songdi.paas.auth.server.util.user.JwtTokenUtil;
import com.songdi.paas.common.exception.auth.UserInvalidException;

@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private UserRest userService;

    @Autowired
    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil, UserRest userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        UserInfo info = userService.validate(authenticationRequest.toMap());
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    }
}
