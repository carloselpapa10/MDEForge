package org.mdeforge.servicemodel.workspace.api.command;

import java.util.List;

import io.eventuate.tram.commands.common.Command;

public class ValidateWorkspaceListByProject implements Command{

	private List<String> workspacesId;

	public ValidateWorkspaceListByProject() {}
	
	public ValidateWorkspaceListByProject(List<String> workspacesId) {
		super();
		this.workspacesId = workspacesId;
	}

	public List<String> getWorkspacesId() {
		return workspacesId;
	}

	public void setWorkspacesId(List<String> workspacesId) {
		this.workspacesId = workspacesId;
	}
	
}
