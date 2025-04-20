package com.eightynine.eightyninebackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eightynine.eightyninebackend.model.CustomerUserDetails;
import com.eightynine.eightyninebackend.model.User;
import com.eightynine.eightyninebackend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
@Autowired

private UserRepository userRepository;

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new CustomerUserDetails(user);
}
  
}
