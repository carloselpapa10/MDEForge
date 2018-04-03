package org.mdeforge.mdeforgeviewservice.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class UserHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(UserHistoryEventHandlers.class);
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.userservice.model.User")
				.build();
		
	}
}
