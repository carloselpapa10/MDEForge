package org.mdeforge.projectservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public Project() {
		super();
	}
	
	
	public Project(String name, String description, String ownerId, List<String> artifactsId, List<String> usersId,
			List<String> workspacesId) {
		super();
		this.name = name;
		Description = description;
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

	public List<String> getArtifactsId() {
		return artifactsId;
	}

	public void setArtifactsId(List<String> artifactsId) {
		this.artifactsId = artifactsId;
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
