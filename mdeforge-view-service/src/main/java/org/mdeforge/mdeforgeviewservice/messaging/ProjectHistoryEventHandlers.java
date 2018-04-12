package org.mdeforge.mdeforgeviewservice.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.mdeforgeviewservice.impl.ProjectServiceImpl;
import org.mdeforge.mdeforgeviewservice.model.Project;
import org.mdeforge.mdeforgeviewservice.repository.ProjectRepository;
import org.mdeforge.servicemodel.project.api.events.ProjectCompletedEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectCreatedEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectRejectedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class ProjectHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectHistoryEventHandlers.class);
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.projectservice.model.Project")
				.onEvent(ProjectCreatedEvent.class, this::handleProjectCreatedEvent)
				.onEvent(ProjectCompletedEvent.class, this::handleProjectCompletedEvent)
				.onEvent(ProjectRejectedEvent.class, this::handleProjectRejectedEvent)
				.build();
	}
	
	private void handleProjectCreatedEvent(DomainEventEnvelope<ProjectCreatedEvent> dee) {
		log.info("handleProjectCreatedEvent() - ProjectHistoryEventHandlers");
		
		Project project = new Project(dee.getAggregateId(), dee.getEvent().getProjectInfo().getName(), 
										dee.getEvent().getProjectInfo().getOwnerId(), dee.getEvent().getProjectInfo().getArtifactsId(), 
											dee.getEvent().getProjectInfo().getUsersId(), dee.getEvent().getProjectInfo().getWorkspacesId());
		
		projectServiceImpl.create(project);
	}
	
	private void handleProjectCompletedEvent(DomainEventEnvelope<ProjectCompletedEvent> dee) {
		log.info("handleProjectCompletedEvent() - ProjectHistoryEventHandlers");
		
		Project project = projectServiceImpl.findOne(dee.getAggregateId());
		project.setCompleted(true);
		
		projectRepository.save(project);
	}
	
	private void handleProjectRejectedEvent(DomainEventEnvelope<ProjectRejectedEvent> dee) {
		log.info("handleProjectRejectedEvent() - ProjectHistoryEventHandlers");
		
		projectServiceImpl.delete(dee.getAggregateId());
	}
}
