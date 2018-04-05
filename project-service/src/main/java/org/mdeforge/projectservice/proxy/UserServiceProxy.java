package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.user.api.command.CompensateShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ShareProjectToUserList;
import org.mdeforge.servicemodel.user.api.command.ValidateUserByProject;

import io.eventuate.tram.commands.common.Success;

@Component
public class UserServiceProxy {

	public final CommandEndpoint<ValidateUserByProject> validateUser = CommandEndpointBuilder
											.forCommand(ValidateUserByProject.class)
											.withChannel(Channels.USER_SERVICE)
											.withReply(Success.class)
											.build();
	
	public final CommandEndpoint<ShareProjectToUserList> shareProjectToUsers = CommandEndpointBuilder
											.forCommand(ShareProjectToUserList.class)
											.withChannel(Channels.USER_SERVICE)
											.withReply(Success.class)
											.build();
	
	public final CommandEndpoint<CompensateShareProjectToUserList> compensateShareProjectToUsers = CommandEndpointBuilder
											.forCommand(CompensateShareProjectToUserList.class)
											.withChannel(Channels.USER_SERVICE)
											.withReply(Success.class)
											.build();
}
