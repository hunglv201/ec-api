package com.vn.ec.common.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppException(String exception) {
        super(exception);
    }

    public AppException() {
        super();
    }
}
