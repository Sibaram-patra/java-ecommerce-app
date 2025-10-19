package com.project.e_commerce.service.impl;

import com.project.e_commerce.model.User;
import com.project.e_commerce.repository.UserRepository;
import com.project.e_commerce.service.UserService;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
     @Autowired
     private UserRepository userRepository;
     
     @Autowired
     private PasswordEncoder passwordEncoder;
     
     @Override
     public User saveUser(User user) {
    	 // Encode password
    	 user.setPassword(passwordEncoder.encode(user.getPassword()));
    	 
    	 // CRITICAL FIX: Set role to "ROLE_USER" not just "USER"
    	 if (user.getRole() == null || user.getRole().isBlank()) {
    	     user.setRole("ROLE_USER");
    	 }
    	 
    	 return userRepository.save(user);
     }
     
     @Override
     public Optional<User> getUserById(Long id) {
    	 return userRepository.findById(id);
     }
     
     @Override
     public Optional<User> findUserByEmail(String email) {
    	 return userRepository.findByEmail(email);
     }
     
     @Override
     public List<User> getAllUsers() {
    	 return userRepository.findAll();
     }
     
     @Override
     public void deleteUser(Long id) {
    	 userRepository.deleteById(id);
     }
}