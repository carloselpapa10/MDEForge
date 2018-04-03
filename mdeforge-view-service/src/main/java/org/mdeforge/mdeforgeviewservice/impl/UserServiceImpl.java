package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

	@Override
	public User create(User user) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOneByUsername(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
