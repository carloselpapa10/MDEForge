package org.mdeforge.workspaceservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.project.api.command.ValidateProjectListByWorkspace;

import io.eventuate.tram.commands.common.Success;

@Component
public class ProjectServiceProxy {

	public final CommandEndpoint<ValidateProjectListByWorkspace> validateProjects = CommandEndpointBuilder
									.forCommand(ValidateProjectListByWorkspace.class)
									.withChannel(Channels.PROJECT_SERVICE)
									.withReply(Success.class)
									.build();
}
