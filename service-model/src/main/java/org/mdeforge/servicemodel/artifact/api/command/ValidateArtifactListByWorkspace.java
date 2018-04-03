package org.mdeforge.servicemodel.artifact.api.command;

import java.util.List;

import io.eventuate.tram.commands.common.Command;

public class ValidateArtifactListByWorkspace implements Command{

	private List<String> artifactsList;
	
	public ValidateArtifactListByWorkspace() {}
	
	public ValidateArtifactListByWorkspace(List<String> artifactsList) {
		super();
		this.artifactsList = artifactsList;
	}

	public List<String> getArtifactsList() {
		return artifactsList;
	}

	public void setArtifactsList(List<String> artifactsList) {
		this.artifactsList = artifactsList;
	}

}
