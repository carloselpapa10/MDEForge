package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String image;
	private boolean enabled;
	private String password;
	private List<Role> roles = new ArrayList<>();
	
	/*	
	private List<ArtifactInfo> owner = new ArrayList<>();
	private List<ProjectInfo> sharedProject = new ArrayList<>();
	private List<ArtifactInfo> sharedArtifact = new ArrayList<>();
	private List<WorkspaceInfo> workspaces = new ArrayList<>();
	*/
	
	public User() {}	
	
	public User(String firstname, String lastname, String email, String username, String image,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.image = image;
		this.password = password;
		this.enabled = true;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	
}
