package org.mdeforge.projectservice.saga.updateproject;

import org.mdeforge.projectservice.proxy.ArtifactServiceProxy;
import org.mdeforge.projectservice.proxy.ProjectServiceProxy;
import org.mdeforge.projectservice.proxy.UserServiceProxy;
import org.mdeforge.projectservice.proxy.WorkspaceServiceProxy;
import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByProject;
import org.mdeforge.servicemodel.project.api.command.UpdateProjectCommand;
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
public class UpdateProjectSaga implements SimpleSaga<UpdateProjectSagaData>{

	private static final Logger log = LoggerFactory.getLogger(UpdateProjectSaga.class);
	
	private SagaDefinition<UpdateProjectSagaData> sagaDefinition;
	
	public UpdateProjectSaga(ProjectServiceProxy projectService, ArtifactServiceProxy artifactService, UserServiceProxy userService, 
							WorkspaceServiceProxy workspaceService) {
		
		this.sagaDefinition =
				step()
					.invokeParticipant(userService.validateUser, this::makeValidateUserByProject)
				.step()
					.invokeParticipant(workspaceService.validateWorkspaces, this::makeValidateWorkspaceListByProject)
				.step()
					.invokeParticipant(artifactService.validateArtifacts, this::makeValidateArtifactListByProject)
				.step()
					.invokeParticipant(userService.shareProjectToUsers, this::makeShareProjectToUsers)
					.withCompensation(userService.compensateShareProjectToUsers, this::makeCompensateShareProjectToUsers)
				.step()
					.invokeParticipant(projectService.update, this::makeUpdateProject)
				.build();
	}
	
	@Override
	public SagaDefinition<UpdateProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	} 
	
	public ValidateUserByProject makeValidateUserByProject(UpdateProjectSagaData data) {
		log.info("makeValidateUserByProject() - UpdateProjectSaga"); 
		return new ValidateUserByProject();
	}
	
	private ValidateWorkspaceListByProject makeValidateWorkspaceListByProject(UpdateProjectSagaData data) {
		log.info("makeValidateWorkspaceListByProject() - UpdateProjectSaga"); 
		return new ValidateWorkspaceListByProject();
	}
	
	private ValidateArtifactListByProject makeValidateArtifactListByProject(UpdateProjectSagaData data) {
		log.info("makeValidateArtifactListByProject() - UpdateProjectSaga"); 
		return new ValidateArtifactListByProject();
	}
	
	private ShareProjectToUserList makeShareProjectToUsers(UpdateProjectSagaData data) {
		log.info("makeShareProjectToUsers() - UpdateProjectSaga"); 
		return new ShareProjectToUserList();
	}
	
	private CompensateShareProjectToUserList makeCompensateShareProjectToUsers(UpdateProjectSagaData data) {
		log.info("makeCompensateShareProjectToUsers() - UpdateProjectSaga"); 
		return new CompensateShareProjectToUserList();
	}
	
	private UpdateProjectCommand makeUpdateProject(UpdateProjectSagaData data) {
		log.info("UpdateProjectCommand() - UpdateProjectSaga"); 
		return new UpdateProjectCommand();
	}
	
}
