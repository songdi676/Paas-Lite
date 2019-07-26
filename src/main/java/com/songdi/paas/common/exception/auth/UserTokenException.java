package com.songdi.paas.common.exception.auth;

import com.songdi.paas.common.constant.CommonConstants;
import com.songdi.paas.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
