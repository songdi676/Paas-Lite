package com.songdi.paas.auth.client.jwt;

import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.songdi.paas.auth.client.config.UserAuthConfig;
import com.songdi.paas.auth.common.util.jwt.IJWTInfo;
import com.songdi.paas.auth.common.util.jwt.JWTHelper;
import com.songdi.paas.common.exception.auth.UserTokenException;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
public class UserAuthUtil {
    @Autowired
    private UserAuthConfig userAuthConfig;

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new UserTokenException("User token expired!");
        } catch (SignatureException ex) {
            throw new UserTokenException("User token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new UserTokenException("User token is null or empty!");
        }
    }
}
