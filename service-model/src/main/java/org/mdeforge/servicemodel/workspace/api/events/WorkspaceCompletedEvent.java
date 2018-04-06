package org.mdeforge.servicemodel.workspace.api.events;

public class WorkspaceCompletedEvent implements WorkspaceDomainEvent{

	private String workspaceId;

	public WorkspaceCompletedEvent() {}
	
	public WorkspaceCompletedEvent(String workspaceId) {
		super();
		this.workspaceId = workspaceId;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}
	
}
