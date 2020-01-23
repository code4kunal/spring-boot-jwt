package com.java.multitenancy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
    LOGGER.error("exception : ",(Object[])ex.getStackTrace());
    ExceptionResponse exceptionResponse = ExceptionResponse.builder().message(ex.getMessage())
        .code(HttpStatus.INTERNAL_SERVER_ERROR).build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(InvalidUserException.class)
  public final ResponseEntity<ExceptionResponse> handleInvalidUserException
      (InvalidUserException ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder().message(ex.getMessage())
        .code(ex.getCode()).build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public final ResponseEntity<ExceptionResponse> handleNgoAlreadyExistsException
      (Exception ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder().message(ex.getMessage())
        .code(HttpStatus.BAD_REQUEST).build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
