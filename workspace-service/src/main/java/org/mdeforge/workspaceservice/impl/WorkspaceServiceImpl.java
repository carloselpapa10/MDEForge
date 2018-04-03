package org.mdeforge.workspaceservice.impl;

import java.util.List;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCreatedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDomainEvent;
import org.mdeforge.servicemodel.workspace.api.info.WorkspaceInfo;
import org.mdeforge.workspaceservice.dao.WorkspaceService;
import org.mdeforge.workspaceservice.model.Workspace;
import org.mdeforge.workspaceservice.model.WorkspaceDomainEventPublisher;
import org.mdeforge.workspaceservice.model.WorkspaceRepository;
import org.mdeforge.workspaceservice.saga.createworkspace.CreateWorkspaceSagaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import static java.util.Collections.singletonList;
import io.eventuate.tram.sagas.orchestration.SagaManager;

@Component
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private SagaManager<CreateWorkspaceSagaData> createWorkspaceSagaManager;
	
	@Autowired
	private WorkspaceDomainEventPublisher workspaceAggregateEventPublisher;
	
	@Override
	public Workspace create(Workspace workspace) throws BusinessException {
		log.info("create - WorkspaceServiceImpl "+workspace);
		
		WorkspaceInfo workspaceInfo = new WorkspaceInfo(workspace.getId(),workspace.getDescription(), workspace.getName(),
														workspace.getOwnerId(),workspace.isCompleted(),workspace.getProjectsId(),
														workspace.getArtifactsId());
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCreatedEvent(workspaceInfo));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);
		
		workspace = workspaceRepository.save(workspace);
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
		
		CreateWorkspaceSagaData data = new CreateWorkspaceSagaData(workspace.getId(),workspace.getOwnerId(),workspace.getProjectsId(),workspace.getArtifactsId());
		createWorkspaceSagaManager.create(data, Workspace.class, workspace.getId());
		
		return workspace;
	}

	@Override
	public List<Workspace> findAll() throws BusinessException {
		log.info("findAll - WorkspaceServiceImpl");
		return workspaceRepository.findAll();
	}

}
