package com.aboshady.stc.advice;

import com.aboshady.stc.dto.ApiError;
import com.aboshady.stc.exception.ApIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/** Provides handling for exceptions throughout this service. */

@ControllerAdvice
public class MainAdvice {
    @ExceptionHandler({ ApIException.class })
    public final ResponseEntity<ApiError> handleException(ApIException ex, WebRequest request) {
        return ResponseEntity.status(ex.getStatus()).body(new ApiError(ex.getMessage()));
    }
}
