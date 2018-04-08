package org.mdeforge.userservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.user.api.command.CompensateShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByProject;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByWorkspace;
import org.mdeforge.userservice.impl.UserServiceImpl;
import org.mdeforge.userservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class UserServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(UserServiceCommandHandlers.class);
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.USER_SERVICE)
				.onMessage(ValidateUserByWorkspace.class, this::handleValidateUserByWorkspace)
				.onMessage(ValidateUserByProject.class, this::handleValidateUserByProject)
				.onMessage(ShareProjectToUserList.class, this::handleShareProjectToUserList)
				.onMessage(CompensateShareProjectToUserList.class, this::handleCompensateShareProjectToUserList)
				.build();
	}
	
	private Message handleValidateUserByWorkspace(CommandMessage<ValidateUserByWorkspace> cm) {
		log.info("handleValidateUserByWorkspace() - UserServiceCommandHandlers");
		
		User user = userServiceImpl.findOne(cm.getCommand().getUserId());
		
		if(user!= null) {
			return withSuccess();
		}
		
		return withFailure();
	}
	
	private Message handleValidateUserByProject(CommandMessage<ValidateUserByProject> cm) {
		log.info("handleValidateUserByProject() - UserServiceCommandHandlers");
		return withSuccess();
	}
	
	private Message handleShareProjectToUserList(CommandMessage<ShareProjectToUserList> cm) {
		log.info("handleShareProjectToUserList() - UserServiceCommandHandlers");
		return withSuccess();
	}
	
	private Message handleCompensateShareProjectToUserList(CommandMessage<CompensateShareProjectToUserList> cm) {
		log.info("handleCompensateShareProjectToUserList() - UserServiceCommandHandlers");
		return withSuccess();
	}
}
