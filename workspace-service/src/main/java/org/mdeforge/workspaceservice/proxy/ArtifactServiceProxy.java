package org.mdeforge.workspaceservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByWorkspace;
import org.mdeforge.servicemodel.common.Channels;

import io.eventuate.tram.commands.common.Success;

@Component
public class ArtifactServiceProxy {

	public final CommandEndpoint<ValidateArtifactListByWorkspace> validateArtifacts = CommandEndpointBuilder
										.forCommand(ValidateArtifactListByWorkspace.class)
										.withChannel(Channels.ARTIFACT_SERVICE)
										.withReply(Success.class)
										.build();
}
