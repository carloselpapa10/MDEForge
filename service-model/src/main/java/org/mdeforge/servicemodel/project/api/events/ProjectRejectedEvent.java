package org.mdeforge.servicemodel.project.api.events;

public class ProjectRejectedEvent implements ProjectDomainEvent{

	private String projectId;

	public ProjectRejectedEvent() {}
	
	public ProjectRejectedEvent(String projectId) {
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
