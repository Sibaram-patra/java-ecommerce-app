package com.project.e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
   
   private final CustomAuthenticationSuccessHandler successHandler;
   
   public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
       this.successHandler = successHandler;
   }
   
   @Bean
   public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
   }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	   http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	        	    .requestMatchers("/", "/home", "/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()
	        	    .requestMatchers("/admin/**").hasRole("ADMIN")
	        	    .requestMatchers("/products").permitAll()
	        	    .anyRequest().authenticated()
	        		)
	        .formLogin(form -> form
	        	    .loginPage("/login")
	        	    .loginProcessingUrl("/login")
	        	    .successHandler(successHandler)
					.failureUrl("/login?error=true")
	        	    .permitAll()
	        	)
	        .logout(logout -> logout
	        	    .logoutSuccessUrl("/login?logout")
	        	    .permitAll()
	        	);
	        return http.build();
   }
}
