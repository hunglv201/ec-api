package com.vn.ec.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidPasswordException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String newPassword, String repPassword) {
        super(String.format("Invalid password: [%s] unlike: [%s] ", newPassword, repPassword));
    }

    public InvalidPasswordException(String newPassword) {
        super(newPassword);
    }
}
