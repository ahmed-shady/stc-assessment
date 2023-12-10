package com.aboshady.stc.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApIException {
    public NotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(){
        super("Not found", HttpStatus.NOT_FOUND);

    }
}
