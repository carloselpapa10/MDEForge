package org.mdeforge.servicemodel.user.api.command;

import java.util.List;

import io.eventuate.tram.commands.common.Command;

public class CompensateShareProjectToUserList implements Command{

	private String projectId;
	private List<String> usersId;
	
	public CompensateShareProjectToUserList() {}
	
	public CompensateShareProjectToUserList(String projectId, List<String> usersId) {
		super();
		this.projectId = projectId;
		this.usersId = usersId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<String> getUsersId() {
		return usersId;
	}

	public void setUsersId(List<String> usersId) {
		this.usersId = usersId;
	}
		
}
