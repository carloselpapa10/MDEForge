package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;

import org.mdeforge.mdeforgeviewservice.model.Role;


public interface RoleService {

	public List<Role> findAll();
	public Role findById(String id);
}

