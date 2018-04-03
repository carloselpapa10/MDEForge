package org.mdeforge.servicemodel.project.api.command;

import java.util.List;

import io.eventuate.tram.commands.common.Command;

public class ValidateProjectListByWorkspace implements Command{

	private List<String> projectsId;
	
	public ValidateProjectListByWorkspace() {}

	public ValidateProjectListByWorkspace(List<String> projectsId) {
		super();
		this.projectsId = projectsId;
	}

	public List<String> getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(List<String> projectsId) {
		this.projectsId = projectsId;
	}
	
}
