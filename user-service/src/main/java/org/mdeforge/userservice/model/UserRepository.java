package org.mdeforge.userservice.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

	public User findByUsernameAndEnabled(String username, boolean enabled);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List<User> findByUsernameContaining(String name);
}
