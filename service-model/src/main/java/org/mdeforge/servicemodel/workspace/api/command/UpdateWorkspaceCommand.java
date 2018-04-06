package org.mdeforge.servicemodel.workspace.api.command;

import org.mdeforge.servicemodel.workspace.api.info.WorkspaceInfo;

import io.eventuate.tram.commands.common.Command;

public class UpdateWorkspaceCommand implements Command{

	private WorkspaceInfo workspaceInfo;

	public UpdateWorkspaceCommand() {}
	
	public UpdateWorkspaceCommand(WorkspaceInfo workspaceInfo) {
		super();
		this.workspaceInfo = workspaceInfo;
	}

	public WorkspaceInfo getWorkspaceInfo() {
		return workspaceInfo;
	}

	public void setWorkspaceInfo(WorkspaceInfo workspaceInfo) {
		this.workspaceInfo = workspaceInfo;
	}
	
}
