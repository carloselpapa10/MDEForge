package org.mdeforge.projectservice.saga.updateproject;

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
public class UpdateProjectSaga implements SimpleSaga<UpdateProjectSagaData>{

	private static final Logger log = LoggerFactory.getLogger(UpdateProjectSaga.class);
	
	private SagaDefinition<UpdateProjectSagaData> sagaDefinition;
	
	public UpdateProjectSaga(ProjectServiceProxy projectService, ArtifactServiceProxy artifactService, UserServiceProxy userService, 
							WorkspaceServiceProxy workspaceService) {
		
	}
	
	@Override
	public SagaDefinition<UpdateProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	} 
	
}
