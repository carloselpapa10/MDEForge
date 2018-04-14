package org.mdeforge.projectservice.commandhandlers;

import org.mdeforge.projectservice.impl.ProjectServiceImpl;
import org.mdeforge.projectservice.model.Project;
import org.mdeforge.projectservice.model.ProjectDomainEventPublisher;
import org.mdeforge.projectservice.model.ProjectRepository;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.project.api.command.CompleteProjectCommand;
import org.mdeforge.servicemodel.project.api.command.DeleteProjectCommand;
import org.mdeforge.servicemodel.project.api.command.RejectProjectCommand;
import org.mdeforge.servicemodel.project.api.command.UpdateProjectCommand;
import org.mdeforge.servicemodel.project.api.command.ValidateProjectListByWorkspace;
import org.mdeforge.servicemodel.project.api.events.ProjectCompletedEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectDeletedEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectDomainEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectRejectedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import java.util.List;
import static java.util.Collections.singletonList;

public class ProjectServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceCommandHandlers.class);
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@Autowired
	private ProjectRepository projectRepository; 
	
	@Autowired
	private ProjectDomainEventPublisher projectDomainEventPublisher;
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.PROJECT_SERVICE)
				.onMessage(RejectProjectCommand.class, this::handleRejectProjectCommand)
				.onMessage(CompleteProjectCommand.class, this::handleCompleteProjectCommand)
				.onMessage(ValidateProjectListByWorkspace.class, this::handleValidateProjectListByWorkspace)
				.onMessage(UpdateProjectCommand.class, this::handleUpdateProjectCommand)
				.onMessage(DeleteProjectCommand.class, this::handleDeleteProjectCommand)
				.build();
	}
	
	private Message handleRejectProjectCommand(CommandMessage<RejectProjectCommand> cm) {
		log.info("handleRejectProjectCommand() - ProjectServiceCommandHandlers");
		
		RejectProjectCommand command = cm.getCommand();
		
		Project project = projectServiceImpl.findOne(command.getProjectId());
		
		if(project == null) {
			withFailure();
		}
		
		log.info("project rejected successfully projectId: "+project.getId());
		project.setCompleted(false);
		
		List<ProjectDomainEvent> events = singletonList(new ProjectRejectedEvent(project.getId()));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAnAndEvents = new ResultWithDomainEvents<>(project,events);
		
		projectRepository.save(project);
		projectDomainEventPublisher.publish(project, projectAnAndEvents.events);
		
		return withSuccess();
	}
	
	private Message handleCompleteProjectCommand(CommandMessage<CompleteProjectCommand> cm) {
		log.info("handleCompleteProjectCommand() - ProjectServiceCommandHandlers");
		
		CompleteProjectCommand command = cm.getCommand();
		
		Project project = projectServiceImpl.findOne(command.getProjectId());
		
		if(project == null) {
			withFailure();
		}
		
		log.info("project completed successfully projectId: "+project.getId());
		project.setCompleted(true);
		
		List<ProjectDomainEvent> events = singletonList(new ProjectCompletedEvent(project.getId()));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAnAndEvents = new ResultWithDomainEvents<>(project,events);
		
		projectRepository.save(project);
		projectDomainEventPublisher.publish(project, projectAnAndEvents.events);
		
		return withSuccess();
	}
	
	private Message handleValidateProjectListByWorkspace(CommandMessage<ValidateProjectListByWorkspace> cm) {
		log.info("handleValidateProjectListByWorkspace() - ProjectServiceCommandHandlers");
		
		List<String> projectsId = cm.getCommand().getProjectsId();
		
		for(String projId : projectsId) {
			if(projectServiceImpl.findOne(projId) == null) {
				return withFailure();
			}
		}
	
		return withSuccess();
	}
	
	private Message handleUpdateProjectCommand(CommandMessage<UpdateProjectCommand> cm) {
		log.info("handleUpdateProjectCommand() - ProjectServiceCommandHandlers");
		
		return withSuccess();
	}
	
	private Message handleDeleteProjectCommand(CommandMessage<DeleteProjectCommand> cm) {
		log.info("handleDeleteProjectCommand() - ProjectServiceCommandHandlers");
		
		DeleteProjectCommand command = cm.getCommand();
		
		Project project = projectServiceImpl.findOne(command.getProjectId());
		
		if(project == null) {
			withFailure();
		}
		
		log.info("project deleted successfully projectId: "+project.getId());
		
		List<ProjectDomainEvent> events = singletonList(new ProjectDeletedEvent(project.getId()));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);
		
		projectDomainEventPublisher.publish(project, projectAndEvents.events);
		projectRepository.delete(project);
		
		return withSuccess();
	}
}
