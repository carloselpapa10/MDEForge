package org.mdeforge.userservice.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.mdeforge.userservice.dao.RoleService;
import org.mdeforge.userservice.model.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.userservice.model.Role;

@Component
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(String id) {
		
		try {
			Role role = roleRepository.findById(id).get();
			return role;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
