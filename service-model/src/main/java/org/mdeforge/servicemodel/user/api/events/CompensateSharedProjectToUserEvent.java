package org.mdeforge.servicemodel.user.api.events;

public class CompensateSharedProjectToUserEvent implements UserDomainEvent{

	private String projectId;
	private String userId;
	
	public CompensateSharedProjectToUserEvent() {}
	
	public CompensateSharedProjectToUserEvent(String projectId, String userId) {
		super();
		this.projectId = projectId;
		this.userId = userId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
