package com.epam.microservices.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    private static final String ERROR_PROCESSING_REQUEST = "There was an error processing the request";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError otherException() {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                ERROR_PROCESSING_REQUEST);
    }

}
