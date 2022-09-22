package com.quizeportal.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeportal.model.userModel.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
