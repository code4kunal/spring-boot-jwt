package com.java.multitenancy.service;

import com.java.multitenancy.persistence.POJO.LoginRequest;
import com.java.multitenancy.persistence.POJO.LoginRespnse;
import com.java.multitenancy.persistence.POJO.UserRequest;
import com.java.multitenancy.persistence.entity.UserEntity;
import java.util.List;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public UserEntity createUser(UserRequest userRequest) {
    return null;
  }

  public LoginRespnse userLogin(LoginRequest loginRequest) {
    return null;
  }

  public UserEntity getUser(int userId, HttpRequest request) {
    return null;
  }

  public List<UserEntity> getAllUser(int userId, HttpRequest request) {
    return null;
  }

  public UserEntity updateUser(String userId, UserRequest userRequest, HttpRequest request) {
    return null;
  }

  public void deleteUser(String userId, HttpRequest request) {
  }
}
