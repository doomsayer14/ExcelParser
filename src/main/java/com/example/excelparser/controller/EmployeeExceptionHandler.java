package com.example.excelparser.controller;

import com.example.excelparser.exception.EmployeeNotFoundException;
import com.example.excelparser.exception.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice(annotations = Controller.class)
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        Response response = new Response(e.getMessage(), LocalTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
