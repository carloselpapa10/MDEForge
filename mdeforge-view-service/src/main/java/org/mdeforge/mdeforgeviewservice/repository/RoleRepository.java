package org.mdeforge.mdeforgeviewservice.repository;

import org.mdeforge.mdeforgeviewservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String>{

}
