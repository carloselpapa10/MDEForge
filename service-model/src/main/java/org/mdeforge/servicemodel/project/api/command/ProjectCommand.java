package org.mdeforge.servicemodel.project.api.command;

import io.eventuate.tram.commands.common.Command;

public class ProjectCommand implements Command{

	private String projectId;

	public ProjectCommand() {}
	
	public ProjectCommand(String projectId) {
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
