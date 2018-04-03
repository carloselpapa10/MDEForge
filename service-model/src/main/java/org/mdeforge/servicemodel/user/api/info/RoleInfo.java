package org.mdeforge.servicemodel.user.api.info;


public class RoleInfo {

	public static final RoleInfo ADMIN;
	public static final RoleInfo USER;
	static {
		ADMIN = new RoleInfo();
		ADMIN.setName("admin");

		USER = new RoleInfo();
		USER.setName("user");
		
	}

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
