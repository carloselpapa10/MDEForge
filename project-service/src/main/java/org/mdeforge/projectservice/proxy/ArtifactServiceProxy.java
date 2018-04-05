package org.mdeforge.projectservice.proxy;


import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

import org.mdeforge.servicemodel.artifact.api.command.ValidateArtifactListByProject;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;

@Component
public class ArtifactServiceProxy {

	public final CommandEndpoint<ValidateArtifactListByProject> validateArtifacts = CommandEndpointBuilder
										.forCommand(ValidateArtifactListByProject.class)
										.withChannel(Channels.ARTIFACT_SERVICE)
										.withReply(Success.class)
										.build();
}
