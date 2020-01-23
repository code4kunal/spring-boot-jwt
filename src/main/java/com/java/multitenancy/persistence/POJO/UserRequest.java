package com.java.multitenancy.persistence.POJO;

import io.swagger.annotations.ApiModelProperty;

public class UserRequest {

  @ApiModelProperty(required = true)
  private String username;
  @ApiModelProperty(required = true)
  private String password;
  private String role;

}
