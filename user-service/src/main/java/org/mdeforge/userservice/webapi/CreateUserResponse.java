package org.mdeforge.userservice.webapi;


public class CreateUserResponse {

	private String id;

	public CreateUserResponse() {}
	
	public CreateUserResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
