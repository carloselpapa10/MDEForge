package org.mdeforge.servicemodel.workspace.api.events;

public class WorkspaceDeletedEvent implements WorkspaceDomainEvent{

	private String workspaceId;

	public WorkspaceDeletedEvent() {}
	
	public WorkspaceDeletedEvent(String workspaceId) {
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
