package org.mdeforge.servicemodel.project.api.command;

import org.mdeforge.servicemodel.project.api.info.ProjectInfo;

import io.eventuate.tram.commands.common.Command;

public class UpdateProjectCommand implements Command{

	private ProjectInfo projectInfo;

	public UpdateProjectCommand() {}
	
	public UpdateProjectCommand(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
}
