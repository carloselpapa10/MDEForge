package org.mdeforge.workspaceservice.proxy;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.command.CompleteWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.RejectWorkspaceCommand;
import org.mdeforge.servicemodel.workspace.api.command.UpdateWorkspaceCommand;
import org.springframework.stereotype.Component;
import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

@Component
public class WorkspaceServiceProxy {

	public final CommandEndpoint<RejectWorkspaceCommand> reject = CommandEndpointBuilder
								.forCommand(RejectWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACE_SERVICE)
								.withReply(Success.class)
								.build();
	
	public final CommandEndpoint<CompleteWorkspaceCommand> complete = CommandEndpointBuilder
								.forCommand(CompleteWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACE_SERVICE)
								.withReply(Success.class)
								.build();
	
	public final CommandEndpoint<UpdateWorkspaceCommand> update = CommandEndpointBuilder
								.forCommand(UpdateWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACE_SERVICE)
								.withReply(Success.class)
								.build();
}
