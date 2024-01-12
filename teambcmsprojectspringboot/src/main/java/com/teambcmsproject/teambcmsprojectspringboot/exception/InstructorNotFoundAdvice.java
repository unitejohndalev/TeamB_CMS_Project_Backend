package com.teambcmsproject.teambcmsprojectspringboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class InstructorNotFoundAdvice {

    @ExceptionHandler(InstructorNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> ExceptionHandler(InstructorNotFound exception){
        Map<String, String>  errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
}
