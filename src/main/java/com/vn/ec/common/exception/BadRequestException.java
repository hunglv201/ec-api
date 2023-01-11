package com.vn.ec.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadRequestException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String msg) {
        super(msg);
    }

}
