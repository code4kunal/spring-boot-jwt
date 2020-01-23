package com.java.multitenancy.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ExceptionResponse {
  private String message;
  private HttpStatus code;
}
