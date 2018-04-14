package org.mdeforge.mdeforgeviewservice.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.mdeforgeviewservice.impl.UserServiceImpl;
import org.mdeforge.mdeforgeviewservice.impl.WorkspaceServiceImpl;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.mdeforgeviewservice.model.Workspace;
import org.mdeforge.mdeforgeviewservice.repository.WorkspaceRepository;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCompletedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCreatedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDeletedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceRejectedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class WorkspaceHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceHistoryEventHandlers.class);
	
	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.workspaceservice.model.Workspace")
				.onEvent(WorkspaceCreatedEvent.class, this::handleWorkspaceCreatedEvent)
				.onEvent(WorkspaceCompletedEvent.class, this::handleWorkspaceCompletedEvent)
				.onEvent(WorkspaceRejectedEvent.class, this::handleWorkspaceRejectedEvent)
				.onEvent(WorkspaceUpdatedEvent.class, this::handleWorkspaceUpdatedEvent)
				.onEvent(WorkspaceDeletedEvent.class, this::handleWorkspaceDeletedEvent)
				.build();
	}
	
	private void handleWorkspaceCreatedEvent(DomainEventEnvelope<WorkspaceCreatedEvent> dee) {
		log.info("handleWorkspaceCreatedEvent() - WorkspaceHistoryEventHandlers");
		log.info("dee "+dee);
		
		User user = userServiceImpl.findOne(dee.getEvent().getWorkspaceInfo().getOwnerId());
		Workspace workspace = new Workspace(dee.getAggregateId(),
												dee.getEvent().getWorkspaceInfo().getName(),
													dee.getEvent().getWorkspaceInfo().getDescription(),
														user);
		
		dee.getEvent().getWorkspaceInfo().getProjectsId().forEach(projectId ->{
			/*search project by id and add it to the workspace object*/
		});
		
		workspaceServiceImpl.create(workspace);
	}
	
	private void handleWorkspaceCompletedEvent(DomainEventEnvelope<WorkspaceCompletedEvent> dee) {
		log.info("handleWorkspaceCompletedEvent() - WorkspaceHistoryEventHandlers");
		
		Workspace workspace = workspaceServiceImpl.findOne(dee.getAggregateId());
		workspace.setCompleted(true);
		
		workspaceRepository.save(workspace);
	}
	
	private void handleWorkspaceRejectedEvent(DomainEventEnvelope<WorkspaceRejectedEvent> dee) {
		log.info("handleWorkspaceRejectedEvent() - WorkspaceHistoryEventHandlers");
		
		workspaceServiceImpl.delete(dee.getAggregateId());
	}
	
	private void handleWorkspaceUpdatedEvent(DomainEventEnvelope<WorkspaceUpdatedEvent> dee) {
		log.info("handleWorkspaceUpdatedEvent() - WorkspaceHistoryEventHandlers");
		
		User user = userServiceImpl.findOne(dee.getEvent().getWorkspaceInfo().getOwnerId());
		
		Workspace workspace = new Workspace(dee.getEvent().getWorkspaceInfo().getId(), 
												dee.getEvent().getWorkspaceInfo().getName(), 
													dee.getEvent().getWorkspaceInfo().getDescription(), 
														user);
		
		dee.getEvent().getWorkspaceInfo().getProjectsId().forEach(projectId ->{
			/*search project by id and add it to the workspace object*/
		});
		
		workspaceServiceImpl.update(workspace);
	}
	
	private void handleWorkspaceDeletedEvent(DomainEventEnvelope<WorkspaceDeletedEvent> dee) {
		log.info("handleWorkspaceDeletedEvent() - WorkspaceHistoryEventHandlers");
		workspaceServiceImpl.delete(dee.getAggregateId());
	}
}
