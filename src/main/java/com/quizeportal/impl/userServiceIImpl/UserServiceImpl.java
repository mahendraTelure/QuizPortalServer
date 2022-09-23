package com.quizeportal.impl.userServiceIImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quizeportal.model.userModel.User;
import com.quizeportal.model.userModel.UserRole;
import com.quizeportal.repository.userRepository.RoleRepository;
import com.quizeportal.repository.userRepository.UserRepository;
import com.quizeportal.service.userService.UserService;

import helper.UserFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
//	creating user
	@Override
	public User creaUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("user is already registerd");
			throw new UserFoundException();
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			this.userRepository.save(user);
			return user;
		}
	}


//	getting user by id 
	@Override
	public User getbyUsername(String username) {
		return this.userRepository.findByUsername(username);
	}


	@Override
	public HttpStatus deleteById(Long id) {
		this.userRepository.deleteById(id);
		return HttpStatus.OK;
	}

}
