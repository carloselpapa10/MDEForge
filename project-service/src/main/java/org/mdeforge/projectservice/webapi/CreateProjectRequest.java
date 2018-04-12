package org.mdeforge.projectservice.webapi;

import java.util.ArrayList;
import java.util.List;

public class CreateProjectRequest {

	private String name;	
	private String Description;
	private String ownerId;
	private List<String> artifactsId = new ArrayList<>();
	private List<String> usersId = new ArrayList<>();
	private List<String> workspacesId = new ArrayList<>();
	
	public CreateProjectRequest() {}
	
	public CreateProjectRequest(String name, String description, String ownerId, List<String> artifactsId,
			List<String> usersId, List<String> workspacesId) {
		super();
		this.name = name;
		Description = description;
		this.ownerId = ownerId;
		this.artifactsId = artifactsId;
		this.usersId = usersId;
		this.workspacesId = workspacesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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
