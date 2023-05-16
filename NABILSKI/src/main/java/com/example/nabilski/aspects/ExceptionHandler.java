package com.example.nabilski.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Map<String, String> HandleException(Exception exception){
        Map map= new HashMap<>();
        map.put("erreur !!!!", exception.getMessage());
        return map;
    }
}
