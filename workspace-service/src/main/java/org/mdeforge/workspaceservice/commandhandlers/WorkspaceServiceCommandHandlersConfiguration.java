package org.mdeforge.workspaceservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

@Configuration
public class WorkspaceServiceCommandHandlersConfiguration {

	@Bean
	public WorkspaceServiceCommandHandlers workspaceServiceCommandHandlers() {
		return new WorkspaceServiceCommandHandlers();
	}
	
	@Bean
	public CommandDispatcher commandDispatcher(WorkspaceServiceCommandHandlers workspaceServiceCommandHandlers) {
		return new SagaCommandDispatcher("workspaceServiceDispatcher", workspaceServiceCommandHandlers.commandHandlers());
	}
}
