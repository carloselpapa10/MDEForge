package org.mdeforge.servicemodel.project.api.events;

public class ProjectDeletedEvent implements ProjectDomainEvent{

	private String projectId;

	public ProjectDeletedEvent() {}
	
	public ProjectDeletedEvent(String projectId) {
		super();
		this.projectId = projectId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
