package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Projects")
public class Project {

	@Id
	private String id;
	private String name;	
	private boolean open;
	private Date createdDate;
	private String Description;
	private Date modifiedDate;	
	private String ownerId;
	private List<String> artifactsId = new ArrayList<>();
	private List<String> usersId = new ArrayList<>();
	private List<String> workspacesId = new ArrayList<>();
	private boolean completed;
	
	public Project() {}
	
	public Project(String id, String name, String ownerId, List<String> artifactsId, List<String> usersId,
			List<String> workspacesId) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.artifactsId = artifactsId;
		this.usersId = usersId;
		this.workspacesId = workspacesId;
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
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
