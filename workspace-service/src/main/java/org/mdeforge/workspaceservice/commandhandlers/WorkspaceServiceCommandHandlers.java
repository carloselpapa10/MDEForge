package org.mdeforge.workspaceservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.command.CompleteWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.RejectWorkspaceCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class WorkspaceServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceCommandHandlers.class);
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.WORKSPACE_SERVICE)
				.onMessage(RejectWorkspaceCommand.class, this::rejectCreateWorkspace)
				.onMessage(CompleteWorkspaceCommand.class, this::completeCreateWorkspace)
				.build();
	}
	
	public Message rejectCreateWorkspace(CommandMessage<RejectWorkspaceCommand> cm) {
		log.info("rejectWorkspace() - WorkspaceServiceCommandHandlers");
		
		return withSuccess();
	}
	
	public Message completeCreateWorkspace(CommandMessage<CompleteWorkspaceCommand> cm) {
		log.info("completeCreateWorkspace() - WorkspaceServiceCommandHandlers");
		
		return withSuccess();
	}
	
}
