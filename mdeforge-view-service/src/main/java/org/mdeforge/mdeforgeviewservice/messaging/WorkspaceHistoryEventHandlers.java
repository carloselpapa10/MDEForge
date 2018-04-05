package org.mdeforge.mdeforgeviewservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCompletedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCreatedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceRejectedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class WorkspaceHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceHistoryEventHandlers.class);
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.workspaceservice.model.Workspace")
				.onEvent(WorkspaceCreatedEvent.class, this::handleWorkspaceCreatedEvent)
				.onEvent(WorkspaceCompletedEvent.class, this::handleWorkspaceCompletedEvent)
				.onEvent(WorkspaceRejectedEvent.class, this::handleWorkspaceRejectedEvent)
				.build();
	}
	
	private void handleWorkspaceCreatedEvent(DomainEventEnvelope<WorkspaceCreatedEvent> dee) {
		log.info("handleWorkspaceCreatedEvent() - WorkspaceHistoryEventHandlers");
		log.info("dee "+dee);
	}
	
	private void handleWorkspaceCompletedEvent(DomainEventEnvelope<WorkspaceCompletedEvent> dee) {
		log.info("handleWorkspaceCompletedEvent() - WorkspaceHistoryEventHandlers");
	}
	
	private void handleWorkspaceRejectedEvent(DomainEventEnvelope<WorkspaceRejectedEvent> dee) {
		log.info("handleWorkspaceRejectedEvent() - WorkspaceHistoryEventHandlers");
	}
}
