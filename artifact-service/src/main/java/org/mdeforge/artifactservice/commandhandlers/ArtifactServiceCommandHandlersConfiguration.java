package org.mdeforge.artifactservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

@Configuration
public class ArtifactServiceCommandHandlersConfiguration {

	@Bean
	public ArtifactServiceCommandHandlers artifactServiceCommandHandlers() {
	    return new ArtifactServiceCommandHandlers();
	}
	
	@Bean
	public CommandDispatcher commandDispatcher(ArtifactServiceCommandHandlers artifactServiceCommandHandlers) {
	    return new SagaCommandDispatcher("artifactServiceDispatcher", artifactServiceCommandHandlers.commandHandlers());
	}
	
}
