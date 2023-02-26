package com.pocketapi.expensetracker.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
Logger logger = LoggerFactory.getLogger(this.getClass());
 /* @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception exception,
                                                          WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(),
            request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ProductException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(ProductException exception,
                                                                  WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(),
            request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }*/



  public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
  /*  ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
            "Invalid Input Parameters",
            exception.getBindingResult().toString());

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);*/
    logger.info("in handle method argument");
    Map<String, String> errors = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error) ->{
      logger.info("in for each");
      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      logger.info("Field name "+fieldName +"message "+message);
      errors.put(fieldName, message);
    });

    return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
  }
}