package org.mdeforge.projectservice.saga.deleteproject;

import org.mdeforge.projectservice.proxy.ProjectServiceProxy;
import org.mdeforge.projectservice.proxy.UserServiceProxy;
import org.mdeforge.servicemodel.project.api.command.DeleteProjectCommand;
import org.mdeforge.servicemodel.user.api.command.RemoveShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class DeleteProjectSaga implements SimpleSaga<DeleteProjectSagaData>{

	private static final Logger log = LoggerFactory.getLogger(DeleteProjectSaga.class);
	
	private SagaDefinition<DeleteProjectSagaData> sagaDefinition;
	
	public DeleteProjectSaga(ProjectServiceProxy projectService, UserServiceProxy userService) {
		this.sagaDefinition =
				step()
					.invokeParticipant(userService.validateUser, this::makeValidateUserByProject)
				.step()
					.invokeParticipant(userService.removeShareProjectToUsers, this::makeRemoveShareProjectToUsers)
				.step()
					.invokeParticipant(projectService.delete, this::makeDeleteProject)
				.build();
	}
	
	@Override
	public SagaDefinition<DeleteProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	} 
	
	private ValidateUserByProject makeValidateUserByProject(DeleteProjectSagaData data) {
		log.info("makeValidateUserByProject() - DeleteProjectSaga"); 
		return new ValidateUserByProject(data.getOwnerId());
	}
	
	private RemoveShareProjectToUserList makeRemoveShareProjectToUsers(DeleteProjectSagaData data) {
		log.info("makeRemoveShareProjectToUsers() - DeleteProjectSaga");
		return new RemoveShareProjectToUserList(data.getProjectId(), data.getUsersId());
	}
	
	private DeleteProjectCommand makeDeleteProject(DeleteProjectSagaData data) {
		log.info("makeDeleteProject() - DeleteProjectSaga");
		return new DeleteProjectCommand(data.getProjectId());
	}
	
}
