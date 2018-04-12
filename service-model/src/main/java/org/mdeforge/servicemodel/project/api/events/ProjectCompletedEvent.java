package org.mdeforge.servicemodel.project.api.events;

public class ProjectCompletedEvent implements ProjectDomainEvent{

	private String projectId;

	public ProjectCompletedEvent() {}
	
	public ProjectCompletedEvent(String projectId) {
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
