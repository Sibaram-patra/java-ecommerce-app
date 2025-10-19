package com.project.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.e_commerce.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
}
