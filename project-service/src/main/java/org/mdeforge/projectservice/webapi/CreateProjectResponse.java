package org.mdeforge.projectservice.webapi;

public class CreateProjectResponse {

	private String id;

	public CreateProjectResponse() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CreateProjectResponse(String id) {
		super();
		this.id = id;
	}
	
}
