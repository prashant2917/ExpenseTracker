package com.pocketapi.expensetracker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pocketapi.expensetracker.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@Order(Ordered.HIGHEST_PRECEDENCE)
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

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    logger.info("in handle method argument");
     List<String> errors = new ArrayList<>();

    exception.getBindingResult().getAllErrors().forEach((error) ->{
      logger.info("in for each");
      String message = error.getDefaultMessage();
      logger.info("message "+message);
      errors.add(message);
    });
    ErrorResponse errorResponse = new ErrorResponse("Invalid Input Parameters",errors);

    return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<Object> handleEmptyResultDataAccess(EmptyResultDataAccessException exception) {
    logger.info("in handle method argument");
    List<String> errors = new ArrayList<>();
    errors.add(exception.getMessage());
    ErrorResponse errorResponse = new ErrorResponse("Product Not Exist",errors);

    return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}