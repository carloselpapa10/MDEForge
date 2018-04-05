package org.mdeforge.workspaceservice.webapi;

public class CreateWorkspaceResponse {

	private String id;
	
	public CreateWorkspaceResponse(String id) {
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
