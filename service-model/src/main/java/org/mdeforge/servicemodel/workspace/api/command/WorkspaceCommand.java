package org.mdeforge.servicemodel.workspace.api.command;

import io.eventuate.tram.commands.common.Command;

public class WorkspaceCommand implements Command{

	private String workspaceId;
	
	public WorkspaceCommand() {}

	public WorkspaceCommand(String workspaceId) {
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
