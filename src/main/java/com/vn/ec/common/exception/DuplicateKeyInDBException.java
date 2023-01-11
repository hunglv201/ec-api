package com.vn.ec.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class DuplicateKeyInDBException extends RuntimeException {

    private Map<String, Boolean> err;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DuplicateKeyInDBException(String exception) {
        super(exception);
    }

    public DuplicateKeyInDBException(Map<String, Boolean> error) {
        this.err = error;
    }
}
