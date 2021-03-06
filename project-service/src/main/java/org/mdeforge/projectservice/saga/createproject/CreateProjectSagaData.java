package org.mdeforge.projectservice.saga.createproject;

import java.util.ArrayList;
import java.util.List;

public class CreateProjectSagaData {

	private String projectId;
	private String ownerId;
	private List<String> artifactsId = new ArrayList<>();
	private List<String> usersId = new ArrayList<>();
	private List<String> workspacesId = new ArrayList<>();
	
	public CreateProjectSagaData() {}
	
	public CreateProjectSagaData(String projectId, String ownerId, List<String> artifactsId, List<String> usersId,
			List<String> workspacesId) {
		super();
		this.projectId = projectId;
		this.ownerId = ownerId;
		this.artifactsId = artifactsId;
		this.usersId = usersId;
		this.workspacesId = workspacesId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public List<String> getArtifactsId() {
		return artifactsId;
	}
	public void setArtifactsId(List<String> artifactsId) {
		this.artifactsId = artifactsId;
	}
	public List<String> getUsersId() {
		return usersId;
	}
	public void setUsersId(List<String> usersId) {
		this.usersId = usersId;
	}
	public List<String> getWorkspacesId() {
		return workspacesId;
	}
	public void setWorkspacesId(List<String> workspacesId) {
		this.workspacesId = workspacesId;
	}
	
}
