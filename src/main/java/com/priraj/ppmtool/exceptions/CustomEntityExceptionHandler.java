package com.priraj.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleResponseEntityException
            (ProjectIdentifierException exception, WebRequest request){
        return new ResponseEntity<Object>
                (new ProjectIdentifierExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
