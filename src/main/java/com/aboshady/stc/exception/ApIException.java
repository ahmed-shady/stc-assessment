package com.aboshady.stc.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApIException extends RuntimeException {
    private final HttpStatus status;

    public ApIException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
