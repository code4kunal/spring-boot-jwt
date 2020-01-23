package com.java.multitenancy.persistence.POJO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRequest {
  @ApiModelProperty(required = true)
  private String username;
  @ApiModelProperty(required = true)
  private String password;

}
