package com.priraj.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationService {

    public ResponseEntity<Map> getValidatonErrors(List<FieldError> fieldErrors){
        Map<String,String> errorMap = new HashMap<>();
        for(FieldError fieldError :fieldErrors ){
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ResponseEntity<Map>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
