package com.quizeportal.service.userService;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.quizeportal.model.userModel.User;
import com.quizeportal.model.userModel.UserRole;

public interface UserService {
	
//	for creating user
	public User creaUser(User user, Set<UserRole> userRoles) throws Exception; 
	
//	get user by user name 
	public User getbyUsername(String username);
	
//	delete user by id
	public HttpStatus deleteById(Long id);
	
	
}
