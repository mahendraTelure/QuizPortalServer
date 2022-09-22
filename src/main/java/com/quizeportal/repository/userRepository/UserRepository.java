package com.quizeportal.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeportal.model.userModel.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);

}
