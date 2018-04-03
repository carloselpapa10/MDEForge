package org.mdeforge.workspaceservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;

import org.mdeforge.servicemodel.user.api.command.ValidateUserByWorkspace;


@Component
public class UserServiceProxy {

	public final CommandEndpoint<ValidateUserByWorkspace> validateUser = CommandEndpointBuilder
								.forCommand(ValidateUserByWorkspace.class)
								.withChannel(Channels.USER_SERVICE)
								.withReply(Success.class)
								.build();
}
