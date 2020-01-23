package com.java.multitenancy.constant;

public enum Errors {

  INVALID_USER("Invalid request. Please enter a valid userId."),
  USER_ALREADY_EXISTS("Requested user id already exists.");

  private String error;

  Errors(String error) {
    this.error = error;
  }

  public String getErrorMessage() {
    return this.error;
  }
}
