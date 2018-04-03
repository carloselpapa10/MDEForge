package org.mdeforge.userservice.webapi;


public class CreateUserRequest {

	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String image;
	private String password;
	
	public CreateUserRequest() {}
	
	public CreateUserRequest(String firstname, String lastname, String email, String username, String image,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.image = image;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
