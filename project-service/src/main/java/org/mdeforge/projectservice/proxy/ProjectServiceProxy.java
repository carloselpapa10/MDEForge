package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;

import org.mdeforge.servicemodel.project.api.command.CompleteProjectCommand;
import org.mdeforge.servicemodel.project.api.command.DeleteProjectCommand;
import org.mdeforge.servicemodel.project.api.command.RejectProjectCommand;
import org.mdeforge.servicemodel.project.api.command.UpdateProjectCommand;

@Component
public class ProjectServiceProxy {

	public final CommandEndpoint<RejectProjectCommand> reject = CommandEndpointBuilder
								.forCommand(RejectProjectCommand.class)
								.withChannel(Channels.PROJECT_SERVICE)
								.withReply(Success.class)
								.build();
	
	public final CommandEndpoint<CompleteProjectCommand> complete = CommandEndpointBuilder
								.forCommand(CompleteProjectCommand.class)
								.withChannel(Channels.PROJECT_SERVICE)
								.withReply(Success.class)
								.build();
	
	public final CommandEndpoint<UpdateProjectCommand> update = CommandEndpointBuilder
								.forCommand(UpdateProjectCommand.class)
								.withChannel(Channels.PROJECT_SERVICE)
								.withReply(Success.class)
								.build();

	public final CommandEndpoint<DeleteProjectCommand> delete = CommandEndpointBuilder
								.forCommand(DeleteProjectCommand.class)
								.withChannel(Channels.PROJECT_SERVICE)
								.withReply(Success.class)
								.build();
}