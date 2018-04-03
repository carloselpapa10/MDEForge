package org.mdeforge.servicemodel.workspace.api.info;

import java.util.ArrayList;
import java.util.List;

public class WorkspaceInfo {

	private String id;
	private String description;
	private String name;
	private String ownerId;
	private boolean completed;
	private List<String> projectsId = new ArrayList<>();
	private List<String> artifactsId = new ArrayList<>();
	
	public WorkspaceInfo() {
		super();
	}
	
	public WorkspaceInfo(String id, String description, String name, String ownerId, boolean completed,
			List<String> projectsId, List<String> artifactsId) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.ownerId = ownerId;
		this.completed = completed;
		this.projectsId = projectsId;
		this.artifactsId = artifactsId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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
