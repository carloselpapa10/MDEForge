package org.mdeforge.workspaceservice.saga.createworkspace;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkspaceSagaData {

	private String workspaceId;
	private String userId;
	private List<String> projectsId = new ArrayList<>();
	private List<String> artifactsId = new ArrayList<>();
	
	public CreateWorkspaceSagaData() {}

	public CreateWorkspaceSagaData(String workspaceId, String userId, List<String> projectsId,
			List<String> artifactsId) {
		super();
		this.workspaceId = workspaceId;
		this.userId = userId;
		this.projectsId = projectsId;
		this.artifactsId = artifactsId;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
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

	public List<String> getArtifactsId() {
		return artifactsId;
	}

	public void setArtifactsId(List<String> artifactsId) {
		this.artifactsId = artifactsId;
	}
	
}
