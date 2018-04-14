package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.command.ValidateWorkspaceListByProject;

import io.eventuate.tram.commands.common.Success;

@Component
public class WorkspaceServiceProxy {

	public final CommandEndpoint<ValidateWorkspaceListByProject> validateWorkspaces = CommandEndpointBuilder
									.forCommand(ValidateWorkspaceListByProject.class)
									.withChannel(Channels.WORKSPACE_SERVICE)
									.withReply(Success.class)
									.build();
	
}
