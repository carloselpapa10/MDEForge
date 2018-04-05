package org.mdeforge.servicemodel.user.api.command;

import io.eventuate.tram.commands.common.Command;

public class ValidateUserByProject implements Command{

	private String userId;

	public ValidateUserByProject() {}
	
	public ValidateUserByProject(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
