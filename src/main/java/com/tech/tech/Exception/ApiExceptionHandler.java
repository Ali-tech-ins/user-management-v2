package com.tech.tech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleRequestException(RequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        //1-create payload containing exception details
        Exception exception = new Exception(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("z"))
        );
        //2-return response entity
        return new ResponseEntity<>(exception, badRequest);
    }
}
