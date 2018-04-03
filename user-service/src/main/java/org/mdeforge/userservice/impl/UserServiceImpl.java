package org.mdeforge.userservice.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;
import org.mdeforge.servicemodel.user.api.events.UserCreatedEvent;
import org.mdeforge.servicemodel.user.api.events.UserDomainEvent;
import org.mdeforge.servicemodel.user.api.info.RoleInfo;
import org.mdeforge.servicemodel.user.api.info.UserInfo;
import org.mdeforge.userservice.dao.UserService;
import org.mdeforge.userservice.model.Role;
import org.mdeforge.userservice.model.User;
import org.mdeforge.userservice.model.UserDomainEventPublisher;
import org.mdeforge.userservice.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.Collections.singletonList;

import java.util.ArrayList;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

@Component
@Transactional
public class UserServiceImpl implements UserService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserDomainEventPublisher userAggregateEventPublisher;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl; 
	
	@Override
	public User create(User user) throws BusinessException {
		log.info("create - UserServiceImpl");		
		
		Role role = roleServiceImpl.findById("546f7ba5ce248eba4487eda5");
		user.getRoles().add(role);
		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setId(role.getId());
		roleInfo.setName(role.getName());
		
		List<RoleInfo> roles = new ArrayList<>();
		roles.add(roleInfo);
		UserInfo userInfo = new UserInfo(user.getId(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getUsername(),user.getImage(),roles);
		
		List<UserDomainEvent> events = singletonList(new UserCreatedEvent(userInfo));
		ResultWithDomainEvents<User,UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);
		
		user = userRepository.save(user);
		userAggregateEventPublisher.publish(user, userAndEvents.events);
		
		return user;
	}

	@Override
	public User authenticate(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRegisteredUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createVerificationToken(User user, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(User us, String password_old, String password_new, String password_new_r)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSharedProjectInUsers(ProjectInfo project) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(String id) throws BusinessException {
		
		try {
			User user = userRepository.findById(id).get();
			return user;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<User> findAll() throws BusinessException {
		return userRepository.findAll();
	}

	@Override
	public long countUsers() throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findOneByUsername(String username) throws BusinessException {
		try {
			User user = userRepository.findByUsername(username);
			return user;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public User findOneByEmail(String email) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByUsernameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
