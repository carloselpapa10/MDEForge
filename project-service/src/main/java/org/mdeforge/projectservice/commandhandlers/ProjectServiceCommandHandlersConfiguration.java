package org.mdeforge.projectservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

@Configuration
public class ProjectServiceCommandHandlersConfiguration {

	@Bean
	public ProjectServiceCommandHandlers projectServiceCommandHandlers() {
	    return new ProjectServiceCommandHandlers();
	}
	
	@Bean
	public CommandDispatcher commandDispatcher(ProjectServiceCommandHandlers projectServiceCommandHandlers) {
	    return new SagaCommandDispatcher("projectServiceDispatcher", projectServiceCommandHandlers.commandHandlers());
}
}
