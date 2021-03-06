package org.mdeforge.servicemodel.workspace.api.events;

public class WorkspaceRejectedEvent implements WorkspaceDomainEvent{

	private String workspaceId;

	public WorkspaceRejectedEvent() {}
	
	public WorkspaceRejectedEvent(String workspaceId) {
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
