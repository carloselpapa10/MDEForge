package org.mdeforge.projectservice.saga.deleteproject;

import java.util.ArrayList;
import java.util.List;

public class DeleteProjectSagaData {

	private String projectId;
	private String ownerId;
	private List<String> usersId = new ArrayList<>();
	
	public DeleteProjectSagaData() {}
	
	public DeleteProjectSagaData(String projectId, String ownerId, List<String> usersId) {
		super();
		this.projectId = projectId;
		this.ownerId = ownerId;
		this.usersId = usersId;
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
	public List<String> getUsersId() {
		return usersId;
	}
	public void setUsersId(List<String> usersId) {
		this.usersId = usersId;
	}

}
