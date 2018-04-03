package org.mdeforge.artifactservice.commandhandlers;

import org.mdeforge.artifactservice.impl.ArtifactServiceImpl;
import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByWorkspace;
import org.mdeforge.servicemodel.common.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class ArtifactServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceCommandHandlers.class);
	
	@Autowired
	private ArtifactServiceImpl artifactServiceImpl;
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.ARTIFACT_SERVICE)
				.onMessage(ValidateArtifactListByWorkspace.class, this::handleValidateArtifactListByWorkspace)
				.build();		
	}

	private Message handleValidateArtifactListByWorkspace(CommandMessage<ValidateArtifactListByWorkspace> cm) {
		log.info("handleValidateArtifactListByWorkspace() - ArtifactServiceCommandHandlers");
		
		/*TODO*/
		
		return withSuccess();
	}
}
