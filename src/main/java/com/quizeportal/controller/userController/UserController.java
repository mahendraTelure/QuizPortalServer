package com.quizeportal.controller.userController;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizeportal.model.userModel.Role;
import com.quizeportal.model.userModel.User;
import com.quizeportal.model.userModel.UserRole;
import com.quizeportal.service.userService.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

//		encodng password wit bcryptpassword encoder 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
//	creating user
	@PostMapping("/")
	public User creUser(@RequestBody User user) throws Exception {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setProfile("default.png");
		
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.creaUser(user, roles);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getbyUsername(username);
	}

	@DeleteMapping("/{userId}")
	public HttpStatus deleteByid(@PathVariable("userId") long userId) {
		return this.userService.deleteById(userId);

	}
}
