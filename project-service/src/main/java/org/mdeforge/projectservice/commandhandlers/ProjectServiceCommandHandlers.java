package org.mdeforge.projectservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class ProjectServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceCommandHandlers.class);
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.PROJECT_SERVICE)
				.build();
	}
}
