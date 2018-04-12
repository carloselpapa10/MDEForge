package org.mdeforge.workspaceservice.saga.updateworkspace;

import java.util.ArrayList;
import java.util.List;

public class UpdateWorkspaceSagaData {

	private String workspaceId;
	private String name;
	private String description;	
	private String userId;
	private List<String> projectsId = new ArrayList<>();
	
	public UpdateWorkspaceSagaData() {}
	
	public UpdateWorkspaceSagaData(String workspaceId, String userId, List<String> projectsId) {
		super();
		this.workspaceId = workspaceId;
		this.userId = userId;
		this.projectsId = projectsId;
	}
	
	public UpdateWorkspaceSagaData(String workspaceId, String name, String description, String userId,
			List<String> projectsId) {
		super();
		this.workspaceId = workspaceId;
		this.name = name;
		this.description = description;
		this.userId = userId;
		this.projectsId = projectsId;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(List<String> projectsId) {
		this.projectsId = projectsId;
	}
	
}
