package org.mdeforge.workspaceservice.model;

import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDomainEvent;
import org.springframework.stereotype.Component;

import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher; 

@Component
public class WorkspaceDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Workspace,WorkspaceDomainEvent>{

	public WorkspaceDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, Workspace.class, Workspace::getId);
	}
}
