package org.mdeforge.userservice.dao;

import java.util.List;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;
import org.mdeforge.userservice.model.User;

public interface UserService {

	public User create(User user) throws BusinessException;		
	public void delete(String id) throws BusinessException;
	public void saveRegisteredUser(User user);	
	
	public boolean shareProjectToUserList(List<String> userList, String projectId) throws BusinessException;
	public boolean compensateShareProjectToUserList(List<String> userList, String projectId) throws BusinessException;
	
	public void update(User user) throws BusinessException;
	public void changePassword(User us, String password_old, String password_new, String password_new_r) throws BusinessException;
	public void removeSharedProjectInUsers(ProjectInfo project) throws BusinessException;
	
	public User findOne(String id) throws BusinessException;	
	public List<User> findAll() throws BusinessException;	
	public long countUsers() throws BusinessException;
	public User findOneByUsername(String username) throws BusinessException;
	public User findOneByEmail(String email) throws BusinessException;
	public List<User> findByUsernameContaining(String name);	
	
	/*
	 public User authenticate(String username) throws BusinessException;	
	 public void createVerificationToken(User user, String token);
	 VerificationToken getVerificationToken(String token);
	 * */
}
