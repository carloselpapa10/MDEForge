package org.mdeforge.workspaceservice.saga.updateworkspace;

import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

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
		
		/*saga definition*/
	}
	
	@Override
	public SagaDefinition<UpdateWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}	
	
}
