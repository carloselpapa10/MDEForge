package org.mdeforge.workspaceservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String description;	
	private String ownerId;
	private boolean completed;
	private List<String> projectsId = new ArrayList<>();
	private List<String> artifactsId = new ArrayList<>();
	
	public Workspace() {
		super();
	}
	
	public Workspace(String name, String description, String ownerId, List<String> projectsId,
			List<String> artifactsId) {
		super();
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
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
