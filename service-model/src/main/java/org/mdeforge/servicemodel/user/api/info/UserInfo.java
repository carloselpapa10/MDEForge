package org.mdeforge.servicemodel.user.api.info;

import java.util.ArrayList;
import java.util.List;


public class UserInfo {

	private String userId;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String image;
	private boolean enabled;
	private String password;
	private List<RoleInfo> roles = new ArrayList<>();
	
	public UserInfo() {
		super();
	}
		
	public UserInfo(String firstname, String lastname, String email, String username, boolean enabled, String password,
			List<RoleInfo> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.enabled = enabled;
		this.password = password;
		this.roles = roles;
	}

	public UserInfo(String userId, String firstname, String lastname, String email, String username, String image, 
			List<RoleInfo> roles) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.image = image;
		this.roles = roles;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleInfo> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}
	
}
