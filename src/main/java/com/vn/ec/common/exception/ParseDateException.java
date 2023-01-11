package com.vn.ec.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParseDateException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ParseDateException() {
        super();
    }
}
