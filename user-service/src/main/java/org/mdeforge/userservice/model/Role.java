package org.mdeforge.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Role")
public class Role {

	public static final Role ADMIN;
	public static final Role USER;
	static {
		ADMIN = new Role();
		ADMIN.setName("admin");

		USER = new Role();
		USER.setName("user");
		
	}
	@Id
	private String id;
	private String name;	

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}
}
