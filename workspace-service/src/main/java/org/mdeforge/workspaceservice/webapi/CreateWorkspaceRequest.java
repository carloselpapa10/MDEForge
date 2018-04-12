package org.mdeforge.workspaceservice.webapi;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkspaceRequest {

	private String name;
	private String description;
	private String ownerId;
	private List<String> projectsId = new ArrayList<>();
	
	public CreateWorkspaceRequest() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public List<String> getProjectsId() {
		return projectsId;
	}
	public void setProjectsId(List<String> projectsId) {
		this.projectsId = projectsId;
	}
}
