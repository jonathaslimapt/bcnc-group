package com.modules.bcncgroup.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), ex.getMessage()));
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errors.toString());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ProblemDetail itemNotFound(ItemNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NO_CONTENT, ex.getMessage());
    }
}
