package org.mdeforge.userservice.dao;

import java.util.List;

import org.mdeforge.userservice.model.Role;

public interface RoleService {

	public List<Role> findAll();
	public Role findById(String id);
}
