package org.mdeforge.workspaceservice.saga.updateworkspace;

import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByWorkspace;
import org.mdeforge.servicemodel.project.api.command.ValidateProjectListByWorkspace;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByWorkspace;
import org.mdeforge.servicemodel.workspace.api.command.UpdateWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.info.WorkspaceInfo;
import org.mdeforge.workspaceservice.proxy.ArtifactServiceProxy;
import org.mdeforge.workspaceservice.proxy.ProjectServiceProxy;
import org.mdeforge.workspaceservice.proxy.UserServiceProxy;
import org.mdeforge.workspaceservice.proxy.WorkspaceServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UpdateWorkspaceSaga implements SimpleSaga<UpdateWorkspaceSagaData>{

	private static final Logger log = LoggerFactory.getLogger(UpdateWorkspaceSaga.class);
	
	private SagaDefinition<UpdateWorkspaceSagaData> sagaDefinition;
	
	
	public UpdateWorkspaceSaga(WorkspaceServiceProxy workspaceService, UserServiceProxy userService, ProjectServiceProxy projectService,
									ArtifactServiceProxy artifactService) {	
		
		this.sagaDefinition =
				step()
					.invokeParticipant(userService.validateUser, this::makeValidateUserByWorkspace)
				.step()
					.invokeParticipant(projectService.validateProjects, this::makeValidateProjectListByWorkspace)
				.step()
					.invokeParticipant(artifactService.validateArtifacts, this::makeValidateArtifactListByWorkspace)
				.step()
					.invokeParticipant(workspaceService.update, this::makeUpdateWorkspace)
				.build();
				
	}
	
	@Override
	public SagaDefinition<UpdateWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}	
		
	private ValidateUserByWorkspace makeValidateUserByWorkspace(UpdateWorkspaceSagaData data) {
		log.info("ValidateUserByWorkspace() - UpdateWorkspaceSaga");	
		return new ValidateUserByWorkspace(data.getUserId());
	}
	
	private ValidateProjectListByWorkspace makeValidateProjectListByWorkspace(UpdateWorkspaceSagaData data) {
		log.info("makeValidateProjectListByWorkspace() - UpdateWorkspaceSaga");	
		return new ValidateProjectListByWorkspace(data.getProjectsId());
	}
	
	private ValidateArtifactListByWorkspace makeValidateArtifactListByWorkspace(UpdateWorkspaceSagaData data) {
		log.info("makeValidateArtifactListByWorkspace() - UpdateWorkspaceSaga");	
		return new ValidateArtifactListByWorkspace(data.getArtifactsId());
	}
	
	private UpdateWorkspaceCommand makeUpdateWorkspace(UpdateWorkspaceSagaData data) {
		log.info("makeUpdateWorkspace() - UpdateWorkspaceSaga");
		
		WorkspaceInfo workspaceInfo = new WorkspaceInfo(data.getWorkspaceId(), data.getDescription(), 
											data.getName(), data.getUserId(), data.getProjectsId(), data.getArtifactsId());
		return new UpdateWorkspaceCommand(workspaceInfo);
	}
	
}
