package org.mdeforge.projectservice.saga.createproject;

import org.mdeforge.projectservice.proxy.ArtifactServiceProxy;
import org.mdeforge.projectservice.proxy.ProjectServiceProxy;
import org.mdeforge.projectservice.proxy.UserServiceProxy;
import org.mdeforge.projectservice.proxy.WorkspaceServiceProxy;
import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByProject;
import org.mdeforge.servicemodel.project.api.command.CompleteProjectCommand;
import org.mdeforge.servicemodel.project.api.command.RejectProjectCommand;
import org.mdeforge.servicemodel.user.api.command.CompensateShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByProject;
import org.mdeforge.servicemodel.workspace.api.command.ValidateWorkspaceListByProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class CreateProjectSaga implements SimpleSaga<CreateProjectSagaData>{

	private static final Logger log = LoggerFactory.getLogger(CreateProjectSaga.class);
	
	private SagaDefinition<CreateProjectSagaData> sagaDefinition;
	
	public CreateProjectSaga(ProjectServiceProxy projectService, ArtifactServiceProxy artifactService, UserServiceProxy userService, 
						WorkspaceServiceProxy workspaceService) {
		this.sagaDefinition =
				step()
					.withCompensation(projectService.reject, this::makeRejectProjectCommand)
				.step()
					.invokeParticipant(userService.validateUser, this::makeValidateUserByProject)					
				.step()
					.invokeParticipant(userService.shareProjectToUsers, this::makeShareProjectToUsers)
					.withCompensation(userService.compensateShareProjectToUsers, this::makeCompensateShareProjectToUsers)
				.step()
					.invokeParticipant(workspaceService.validateWorkspaces, this::makeValidateWorkspaceListByProject)
				.step()
					.invokeParticipant(artifactService.validateArtifacts, this::makeValidateArtifactListByProject)
				.step()
					.invokeParticipant(projectService.complete, this::makeCompleteProject)
				.build();
				
	}
	
	@Override
	public SagaDefinition<CreateProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	} 
	
	private RejectProjectCommand makeRejectProjectCommand(CreateProjectSagaData data) {
		log.info("makeRejectProjectCommand() - CreateProjectSaga"); 
		return new RejectProjectCommand();
	}
	
	private ValidateUserByProject makeValidateUserByProject(CreateProjectSagaData data) {
		log.info("makeValidateUserByProject() - CreateProjectSaga"); 
		return new ValidateUserByProject();
	}
	
	private ShareProjectToUserList makeShareProjectToUsers(CreateProjectSagaData data) {
		log.info("makeShareProjectToUsers() - CreateProjectSaga"); 
		return new ShareProjectToUserList();
	}
	
	private CompensateShareProjectToUserList makeCompensateShareProjectToUsers(CreateProjectSagaData data) {
		log.info("makeCompensateShareProjectToUsers() - CreateProjectSaga"); 
		return new CompensateShareProjectToUserList();
	}
	
	private ValidateWorkspaceListByProject makeValidateWorkspaceListByProject(CreateProjectSagaData data) {
		log.info("makeValidateWorkspaceListByProject() - CreateProjectSaga"); 
		return new ValidateWorkspaceListByProject();
	}
	
	private ValidateArtifactListByProject makeValidateArtifactListByProject(CreateProjectSagaData data) {
		log.info("makeValidateArtifactListByProject() - CreateProjectSaga"); 
		return new ValidateArtifactListByProject();
	}
	
	private CompleteProjectCommand makeCompleteProject(CreateProjectSagaData data) {
		log.info("makeCompleteProject() - CreateProjectSaga"); 
		return new CompleteProjectCommand();
	}
}
