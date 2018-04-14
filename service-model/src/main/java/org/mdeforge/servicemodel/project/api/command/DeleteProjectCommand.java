package org.mdeforge.servicemodel.project.api.command;

import io.eventuate.tram.commands.common.Command;

public class DeleteProjectCommand implements Command{

	private String projectId;
	
	public DeleteProjectCommand() {}

	public DeleteProjectCommand(String projectId) {
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
