package org.mdeforge.userservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

@Configuration
public class UserServiceCommandHandlersConfiguration {

	@Bean
	public UserServiceCommandHandlers userServiceCommandHandlers() {
	    return new UserServiceCommandHandlers();
	}
	
	@Bean
	public CommandDispatcher commandDispatcher(UserServiceCommandHandlers userServiceCommandHandlers) {
	    return new SagaCommandDispatcher("userServiceDispatcher", userServiceCommandHandlers.commandHandlers());
}
}
