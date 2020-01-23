package com.java.multitenancy.service;

import com.java.multitenancy.persistence.POJO.LoginRequest;
import com.java.multitenancy.persistence.POJO.LoginRespnse;
import com.java.multitenancy.persistence.POJO.UserRequest;
import com.java.multitenancy.persistence.dao.UserDAO;
import com.java.multitenancy.persistence.entity.User;
import com.java.multitenancy.security.JwtTokenProvider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserDAO userDAO;

  public User createUser(UserRequest userRequest) {

    return null;
  }

  public LoginRespnse userLogin(LoginRequest loginRequest) {
    try {
      String username = loginRequest.getUsername();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
          loginRequest.getPassword()));
      String token = jwtTokenProvider.createToken(username,
          userDAO.findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

//      Map<Object, Object> model = new HashMap<>();
//      model.put("username", username);
//      model.put("token", token);
//      return ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
    return null;
  }

  public User getUser(int userId, HttpRequest request) {
    return null;
  }

  public List<User> getAllUser(int userId, HttpRequest request) {
    return null;
  }

  public User updateUser(String userId, UserRequest userRequest, HttpRequest request) {
    return null;
  }

  public void deleteUser(String userId, HttpRequest request) {
  }
}
