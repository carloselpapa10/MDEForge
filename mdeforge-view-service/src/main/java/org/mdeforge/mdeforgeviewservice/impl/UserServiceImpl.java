package org.mdeforge.mdeforgeviewservice.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.model.Role;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.mdeforgeviewservice.repository.RoleRepository;
import org.mdeforge.mdeforgeviewservice.repository.UserRepository;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class UserServiceImpl implements UserService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Override
	public User create(User user) throws BusinessException {
		log.info("create - UserServiceImpl");
		
		Role role = roleServiceImpl.findById("546f7ba5ce248eba4487eda5");
		user.getRoles().add(role);
		
		return userRepository.save(user);		
	}

	@Override
	public User findOne(String id) throws BusinessException {
		log.info("findOne - UserServiceImpl");
		try {
			User user = userRepository.findById(id).get();
			return user;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public User findOneByUsername(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		log.info("findOne - UserServiceImpl");
		return userRepository.findAll();
	}

	@Override
	public void SharedProjectToUser(User user) throws BusinessException {
		log.info("SharedProjectToUser - UserServiceImpl");
		userRepository.save(user);
	}

	@Override
	public void CompensateSharedProjectToUser(User user) throws BusinessException {
		log.info("CompensateSharedProjectToUser - UserServiceImpl");
		userRepository.save(user);
	}

}
