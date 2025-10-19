package com.project.e_commerce.bootstrap;

import com.project.e_commerce.model.User;
import com.project.e_commerce.repository.UserRepository;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
	public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostConstruct  // CRITICAL FIX: Added this annotation so method runs on startup
    public void init() {
    	if (userRepository.findByUsername("admin").isEmpty()) {
    		User admin = new User();
    		admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN"); 
            userRepository.save(admin);
            
            System.out.println("✓ Admin user created successfully!");
    	}
    	
    	// Optional: Create a test regular user
    	if (userRepository.findByUsername("user").isEmpty()) {
    		User testUser = new User();
    		testUser.setUsername("user");
    		testUser.setEmail("user@example.com");
    		testUser.setPassword(passwordEncoder.encode("user123"));
    		testUser.setRole("ROLE_USER");
    		userRepository.save(testUser);
    		
    		System.out.println("✓ Test user created successfully!");
    	}
    }
}