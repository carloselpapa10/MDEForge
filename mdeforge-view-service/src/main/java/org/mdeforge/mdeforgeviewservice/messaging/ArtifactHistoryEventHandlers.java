package org.mdeforge.mdeforgeviewservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.artifact.api.events.ArtifactCompletedEvent;
import org.mdeforge.servicemodel.artifact.api.events.ArtifactCreatedEvent;
import org.mdeforge.servicemodel.artifact.api.events.ArtifactRejectedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class ArtifactHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(ArtifactHistoryEventHandlers.class);
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.artifactservice.model.Artifact")
				.onEvent(ArtifactCreatedEvent.class, this::handleArtifactCreatedEvent)
				.onEvent(ArtifactCompletedEvent.class, this::handleArtifactCompletedEvent)
				.onEvent(ArtifactRejectedEvent.class, this::handleArtifactRejectedEvent)
				.build();
	}
	
	private void handleArtifactCreatedEvent(DomainEventEnvelope<ArtifactCreatedEvent> dee) {
		log.info("handleArtifactCreatedEvent() - ArtifactHistoryEventHandlers");
	}
	
	private void handleArtifactCompletedEvent(DomainEventEnvelope<ArtifactCompletedEvent> dee) {
		log.info("handleArtifactCompletedEvent() - ArtifactHistoryEventHandlers");
	}
	
	private void handleArtifactRejectedEvent(DomainEventEnvelope<ArtifactRejectedEvent> dee) {
		log.info("handleArtifactRejectedEvent() - ArtifactHistoryEventHandlers");
	}
}