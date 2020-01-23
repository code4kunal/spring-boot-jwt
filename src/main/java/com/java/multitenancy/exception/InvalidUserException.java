package com.java.multitenancy.exception;

import com.java.multitenancy.constant.Errors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidUserException extends RuntimeException{

  private final HttpStatus code;

  public InvalidUserException(Errors message, HttpStatus code) {
    super(message.getErrorMessage());
    this.code = code;

  }
}
