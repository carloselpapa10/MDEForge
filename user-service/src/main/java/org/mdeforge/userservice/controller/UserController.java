package org.mdeforge.userservice.controller;

import java.util.List;

import org.mdeforge.userservice.impl.UserServiceImpl;
import org.mdeforge.userservice.model.Role;
import org.mdeforge.userservice.model.RoleRepository;
import org.mdeforge.userservice.model.User;
import org.mdeforge.userservice.webapi.CreateUserRequest;
import org.mdeforge.userservice.webapi.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/user")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
		
		User user = userServiceImpl.findOneByUsername(createUserRequest.getUsername());
		
		if(user == null) {
			user = userServiceImpl.create(new User(createUserRequest.getFirstname(), 
					createUserRequest.getLastname(), createUserRequest.getEmail(), createUserRequest.getUsername(),
					createUserRequest.getImage(), createUserRequest.getPassword()));
			
			return new CreateUserResponse(user.getId());
		}
		
		return new CreateUserResponse();
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return userServiceImpl.findAll();
	}
	
	@GetMapping("/roles")
	public List<Role> findAllRoles(){
		return roleRepository.findAll();
	}
}
