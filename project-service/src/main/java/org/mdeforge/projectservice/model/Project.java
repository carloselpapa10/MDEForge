package org.mdeforge.projectservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.servicemodel.artifact.api.info.ArtifactInfo;
import org.mdeforge.servicemodel.workspace.api.info.WorkspaceInfo;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Project {

	private String id;
	private String name;	
	private boolean open;
	private Date createdDate;
	private String Description;
	private Date modifiedDate;	
	private List<ArtifactInfo> artifacts = new ArrayList<>();
	//private UserInfo owner;
	//private List<UserInfo> users = new ArrayList<>();
	private List<WorkspaceInfo> workspaces = new ArrayList<>();
	
	
	
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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public List<ArtifactInfo> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<ArtifactInfo> artifacts) {
		this.artifacts = artifacts;
	}
	
	public List<WorkspaceInfo> getWorkspaces() {
		return workspaces;
	}
	public void setWorkspaces(List<WorkspaceInfo> workspaces) {
		this.workspaces = workspaces;
	}
	
}
