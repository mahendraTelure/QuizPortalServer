package com.quizeportal;

//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// 
//import com.quizeportal.model.userModel.Role;
//import com.quizeportal.model.userModel.User;
//import com.quizeportal.model.userModel.UserRole;
//import com.quizeportal.service.userService.UserService;

@SpringBootApplication
public class QuizePortalApplication{

	public static void main(String[] args) {
		SpringApplication.run(QuizePortalApplication.class, args);
	}

	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Autowired
//	UserService userService;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("Starting Code");
//
//		User user = new User();
//		user.setFirstName("Mahendra");
//		user.setLastName("Telure");
//		user.setUsername("mahi");
//		user.setEmail("telure123@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("mahi"));
//		user.setPhone("9561051485");
//		user.setProfile("myProfile.jpg");
//
//		Role role1 = new Role();
//		role1.setRoleId(11L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user2 = this.userService.creaUser(user, userRoleSet);
//		System.out.println(user2.getUsername());
//
//	}

}
