package org.mdeforge.workspaceservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.command.CompleteWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.RejectWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.UpdateWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.ValidateWorkspaceListByProject;
import org.mdeforge.workspaceservice.impl.WorkspaceServiceImpl;
import org.mdeforge.workspaceservice.model.Workspace;
import org.mdeforge.workspaceservice.model.WorkspaceDomainEventPublisher;
import org.mdeforge.workspaceservice.model.WorkspaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import static java.util.Collections.singletonList;

import java.util.List;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCompletedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDomainEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceRejectedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceUpdatedEvent;

public class WorkspaceServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceCommandHandlers.class);
	
	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;
	
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private WorkspaceDomainEventPublisher workspaceDomainEventPublisher; 
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.WORKSPACE_SERVICE)
				.onMessage(RejectWorkspaceCommand.class, this::rejectCreateWorkspace)
				.onMessage(CompleteWorkspaceCommand.class, this::completeCreateWorkspace)
				.onMessage(UpdateWorkspaceCommand.class, this::handleUpdateWorkspace)
				.onMessage(ValidateWorkspaceListByProject.class, this::handleValidateWorkspaceListByProject)
				.build();
	}
	
	public Message rejectCreateWorkspace(CommandMessage<RejectWorkspaceCommand> cm) {
		log.info("rejectWorkspace() - WorkspaceServiceCommandHandlers");
		
		RejectWorkspaceCommand command = cm.getCommand();
		Workspace workspace = workspaceServiceImpl.findOne(command.getWorkspaceId());
		
		if(workspace==null) {
			return withFailure();
		}
		
		log.info("workspace rejected successfully workspaceId: "+workspace.getId());
		workspace.setCompleted(false);
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceRejectedEvent(workspace.getId()));
		ResultWithDomainEvents<Workspace,WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace,events);
		
		workspaceRepository.save(workspace);
		workspaceDomainEventPublisher.publish(workspace, workspaceAndEvents.events);
		
		return withSuccess();
	}
	
	public Message completeCreateWorkspace(CommandMessage<CompleteWorkspaceCommand> cm) {
		log.info("completeCreateWorkspace() - WorkspaceServiceCommandHandlers");
		
		CompleteWorkspaceCommand command = cm.getCommand();
		Workspace workspace = workspaceServiceImpl.findOne(command.getWorkspaceId());
		
		if(workspace==null) {
			return withFailure();
		}
		
		log.info("workspace completed successfully workspaceId: "+workspace.getId());
		workspace.setCompleted(true);
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCompletedEvent(workspace.getId()));
		ResultWithDomainEvents<Workspace,WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace,events);
		
		workspaceRepository.save(workspace);
		workspaceDomainEventPublisher.publish(workspace, workspaceAndEvents.events);
		
		return withSuccess();
	}
	
	public Message handleUpdateWorkspace(CommandMessage<UpdateWorkspaceCommand> cm) {
		log.info("handleUpdateWorkspace() - WorkspaceServiceCommandHandlers");
		
		UpdateWorkspaceCommand command = cm.getCommand();
		Workspace workspace = workspaceServiceImpl.findOne(command.getWorkspaceInfo().getId());
		
		if(workspace==null) {
			return withFailure();
		}
		
		log.info("workspace updated successfully workspaceId: "+workspace.getId());
		workspace.setName(command.getWorkspaceInfo().getName());
		workspace.setDescription(command.getWorkspaceInfo().getDescription());
		workspace.setOwnerId(command.getWorkspaceInfo().getOwnerId());
		workspace.setProjectsId(command.getWorkspaceInfo().getProjectsId());		
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceUpdatedEvent(command.getWorkspaceInfo()));
		ResultWithDomainEvents<Workspace,WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace,events);
		
		workspaceRepository.save(workspace);
		workspaceDomainEventPublisher.publish(workspace, workspaceAndEvents.events);
		
		return withSuccess();
	}
	
	public Message handleValidateWorkspaceListByProject(CommandMessage<ValidateWorkspaceListByProject> cm) {
		log.info("handleUpdateWorkspace() - WorkspaceServiceCommandHandlers");
		/* TODO */
		return withSuccess();
	}
	
}
