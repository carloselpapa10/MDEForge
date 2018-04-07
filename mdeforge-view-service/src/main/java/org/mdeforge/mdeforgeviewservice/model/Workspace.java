package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Workspaces")
public class Workspace {

	private String id;
	private String name;
	private String description;	
	private User owner;
	private List<Project> projectsId = new ArrayList<>();
	private List<Artifact> artifactsId = new ArrayList<>();
	private boolean completed;
	
	public Workspace() {
		super();
	}
	
	public Workspace(String id, String name, String description, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Project> getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(List<Project> projectsId) {
		this.projectsId = projectsId;
	}

	public List<Artifact> getArtifactsId() {
		return artifactsId;
	}

	public void setArtifactsId(List<Artifact> artifactsId) {
		this.artifactsId = artifactsId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
