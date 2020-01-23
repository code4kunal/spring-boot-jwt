package com.java.multitenancy.security;

import com.java.multitenancy.persistence.dao.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  private UserDAO users;

  public CustomUserDetailsService(UserDAO users) {
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.users.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
  }
}