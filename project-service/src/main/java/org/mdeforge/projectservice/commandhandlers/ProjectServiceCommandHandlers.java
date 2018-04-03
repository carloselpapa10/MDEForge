package org.mdeforge.projectservice.commandhandlers;

import org.mdeforge.projectservice.impl.ProjectServiceImpl;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.project.api.command.ValidateProjectListByWorkspace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import java.util.List;

public class ProjectServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceCommandHandlers.class);
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.PROJECT_SERVICE)
				.onMessage(ValidateProjectListByWorkspace.class, this::handleValidateProjectListByWorkspace)
				.build();
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
}
