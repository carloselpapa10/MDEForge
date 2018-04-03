package org.mdeforge.artifactservice.model;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.artifact.api.events.ArtifactDomainEvent;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Component
public class ArtifactDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Artifact,ArtifactDomainEvent>{

	public ArtifactDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, Artifact.class, Artifact::getId);
	}
}
