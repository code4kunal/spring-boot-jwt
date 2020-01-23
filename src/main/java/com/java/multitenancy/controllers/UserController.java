package com.java.multitenancy.controllers;

import com.java.multitenancy.persistence.POJO.LoginRequest;
import com.java.multitenancy.persistence.POJO.LoginRespnse;
import com.java.multitenancy.persistence.POJO.UserRequest;
import com.java.multitenancy.persistence.entity.UserEntity;
import com.java.multitenancy.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service/v1/")
public class UserController {

  @Autowired
  private UserService userService;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @ApiOperation(value = "CreateUser", notes = "create new user API")
  @RequestMapping(value = "user",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
  public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
    UserEntity userEntity = userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
  }

  @ApiOperation(value = "UserLogin", notes = "user login API")
  @RequestMapping(value = "user/login",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
  public ResponseEntity login( @RequestBody LoginRequest loginRequest) {
    LoginRespnse loginRespnse = userService.userLogin(loginRequest);
    return ResponseEntity.ok(loginRespnse);
  }

  @ApiOperation(value = "GetUserById", notes = "get user API")
  @RequestMapping(value = "user",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ResponseEntity getUserById(@PathParam("userId") int userId, HttpRequest request) {
    UserEntity userEntity = userService.getUser(userId, request);
    return ResponseEntity.status(HttpStatus.OK).body(userEntity);
  }

  @ApiOperation(value = "GetAllUsers", notes = "get all users API")
  @RequestMapping(value = "user",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ResponseEntity getAllUsers(@PathParam("userId") int userId, HttpRequest request) {
    List<UserEntity> listOfUsers = userService.getAllUser(userId, request);
    return ResponseEntity.status(HttpStatus.OK).body(listOfUsers);
  }

  @ApiOperation(value = "UpdateUser", notes = "update user API")
  @RequestMapping(value = "user/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
  public ResponseEntity updateUser(@PathVariable("userId") String userId, HttpRequest request,
      @RequestBody  UserRequest userRequest) {
    UserEntity userEntity = userService.updateUser(userId, userRequest, request);
    return ResponseEntity.status(HttpStatus.OK).body(userEntity);
  }

  @ApiOperation(value = "DeleteUser", notes = "delete user API")
  @RequestMapping(value = "user/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
  public ResponseEntity deleteFile(@PathVariable("userId") String userId, HttpRequest request) {
    LOGGER.info("Deleting user with user ID {}", userId);
    userService.deleteUser(userId, request);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted Successfully");
  }
}

