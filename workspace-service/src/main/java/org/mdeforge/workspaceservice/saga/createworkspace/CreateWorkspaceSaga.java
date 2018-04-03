package org.mdeforge.workspaceservice.saga.createworkspace;

import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByWorkspace;
import org.mdeforge.servicemodel.project.api.command.ValidateProjectListByWorkspace;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByWorkspace;
import org.mdeforge.servicemodel.workspace.api.command.CompleteWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.RejectWorkspaceCommand;
import org.mdeforge.workspaceservice.proxy.ArtifactServiceProxy;
import org.mdeforge.workspaceservice.proxy.ProjectServiceProxy;
import org.mdeforge.workspaceservice.proxy.UserServiceProxy;
import org.mdeforge.workspaceservice.proxy.WorkspaceServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class CreateWorkspaceSaga implements SimpleSaga<CreateWorkspaceSagaData>{

	private static final Logger log = LoggerFactory.getLogger(CreateWorkspaceSaga.class);
	
	private SagaDefinition<CreateWorkspaceSagaData> sagaDefinition;
	
	public CreateWorkspaceSaga(WorkspaceServiceProxy workspaceService, UserServiceProxy userService, ProjectServiceProxy projectService,
								ArtifactServiceProxy artifactService) {
		this.sagaDefinition =
				step()
					.withCompensation(workspaceService.reject, this::makeRejectWorkspaceCommand)
				.step()
					.invokeParticipant(userService.validateUser, this::makeValidateUserByWorkspace)
				.step()
					.invokeParticipant(projectService.validateProjects, this::makeValidateProjectListByWorkspace)
				.step()
					.invokeParticipant(artifactService.validateArtifacts, this::makeValidateArtifactListByWorkspace)
				.step()
					.invokeParticipant(workspaceService.complete, this::makeCompleteWorkspace)
				.build();
	}
	
	@Override
	public SagaDefinition<CreateWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}	
	
	private RejectWorkspaceCommand makeRejectWorkspaceCommand(CreateWorkspaceSagaData data) {
		log.info("RejectWorkspaceCommand() - CreateWorkspaceSaga");		
		return new RejectWorkspaceCommand(data.getWorkspaceId());
	}
	
	private ValidateUserByWorkspace makeValidateUserByWorkspace(CreateWorkspaceSagaData data) {
		log.info("ValidateUserByWorkspace() - CreateWorkspaceSaga");	
		return new ValidateUserByWorkspace(data.getUserId());
	}
	
	private ValidateProjectListByWorkspace makeValidateProjectListByWorkspace(CreateWorkspaceSagaData data) {
		log.info("makeValidateProjectListByWorkspace() - CreateWorkspaceSaga");	
		return new ValidateProjectListByWorkspace(data.getProjectsId());
	}
	
	private ValidateArtifactListByWorkspace makeValidateArtifactListByWorkspace(CreateWorkspaceSagaData data) {
		log.info("makeValidateArtifactListByWorkspace() - CreateWorkspaceSaga");	
		return new ValidateArtifactListByWorkspace(data.getArtifactsId());
	}
	
	private CompleteWorkspaceCommand makeCompleteWorkspace(CreateWorkspaceSagaData data) {
		log.info("makeCompleteWorkspace() - CreateWorkspaceSaga");
		return new CompleteWorkspaceCommand(data.getWorkspaceId());
	}
}
