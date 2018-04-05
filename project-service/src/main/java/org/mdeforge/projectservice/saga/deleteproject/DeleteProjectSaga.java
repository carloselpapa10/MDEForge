package org.mdeforge.projectservice.saga.deleteproject;

import org.mdeforge.projectservice.proxy.ArtifactServiceProxy;
import org.mdeforge.projectservice.proxy.ProjectServiceProxy;
import org.mdeforge.projectservice.proxy.UserServiceProxy;
import org.mdeforge.projectservice.proxy.WorkspaceServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class DeleteProjectSaga implements SimpleSaga<DeleteProjectSagaData>{

	private static final Logger log = LoggerFactory.getLogger(DeleteProjectSaga.class);
	
	private SagaDefinition<DeleteProjectSagaData> sagaDefinition;
	
	public DeleteProjectSaga(ProjectServiceProxy projectService, ArtifactServiceProxy artifactService, UserServiceProxy userService, 
						WorkspaceServiceProxy workspaceService) {
		
	}
	
	@Override
	public SagaDefinition<DeleteProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	} 
}
