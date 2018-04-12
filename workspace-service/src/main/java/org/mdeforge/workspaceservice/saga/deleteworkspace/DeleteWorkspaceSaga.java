package org.mdeforge.workspaceservice.saga.deleteworkspace;

import org.springframework.stereotype.Component;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import org.mdeforge.workspaceservice.proxy.ProjectServiceProxy;
import org.mdeforge.workspaceservice.proxy.UserServiceProxy;
import org.mdeforge.workspaceservice.proxy.WorkspaceServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DeleteWorkspaceSaga implements SimpleSaga<DeleteWorkspaceSagaData>{

	private static final Logger log = LoggerFactory.getLogger(DeleteWorkspaceSaga.class);
	
	private SagaDefinition<DeleteWorkspaceSagaData> sagaDefinition;
	
	public DeleteWorkspaceSaga(WorkspaceServiceProxy workspaceService, UserServiceProxy userService, ProjectServiceProxy projectService) {
		
		/*saga definition*/
	}
	
	@Override
	public SagaDefinition<DeleteWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}	
	
}
