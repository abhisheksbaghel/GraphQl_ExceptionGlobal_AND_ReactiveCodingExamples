package com.Graphql.Practice.graphqllearn.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String > handleArgException(MethodArgumentNotValidException ex)
    {
        Map<String,String> errMsg=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errMsg.put(error.getField(),error.getDefaultMessage()));
        return errMsg;
    }

}
