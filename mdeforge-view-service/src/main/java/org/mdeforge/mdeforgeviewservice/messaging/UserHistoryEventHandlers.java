package org.mdeforge.mdeforgeviewservice.messaging;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.mdeforgeviewservice.impl.UserServiceImpl;
import org.mdeforge.mdeforgeviewservice.model.Role;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.servicemodel.user.api.events.UserCreatedEvent;
import org.mdeforge.servicemodel.user.api.events.UserDeletedEvent;
import org.mdeforge.servicemodel.user.api.events.UserUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class UserHistoryEventHandlers {

	private static final Logger log = LoggerFactory.getLogger(UserHistoryEventHandlers.class);

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.userservice.model.User")
				.onEvent(UserCreatedEvent.class, this::handleUserCreatedEvent)
				.onEvent(UserUpdatedEvent.class, this::handleUserUpdatedEvent)
				.onEvent(UserDeletedEvent.class, this::handleUserDeletedEvent)
				.build();
		
	}
	
	public void handleUserCreatedEvent(DomainEventEnvelope<UserCreatedEvent> dee) {
		log.info("handleUserCreatedEvent() - UserHistoryEventHandlers - mdeforge-view-service");
		log.info("dee "+dee);
		
		User user = new User(dee.getAggregateId(),
								dee.getEvent().getUserInfo().getFirstname(),
								dee.getEvent().getUserInfo().getLastname(),
								dee.getEvent().getUserInfo().getEmail(),
								dee.getEvent().getUserInfo().getUsername(),
								dee.getEvent().getUserInfo().isEnabled(),
								dee.getEvent().getUserInfo().getPassword());
		
		List<Role> roleList = new ArrayList<>();
		
		dee.getEvent().getUserInfo().getRoles().forEach(role ->{
			roleList.add(new Role(role.getId(), role.getName()));
		});
		
		user.setRoles(roleList);		
		userServiceImpl.create(user);
	}
	
	public void handleUserUpdatedEvent(DomainEventEnvelope<UserUpdatedEvent> dee) {
		log.info("handleUserUpdatedEvent() - UserHistoryEventHandlers - mdeforge-view-service");
	}
	
	public void handleUserDeletedEvent(DomainEventEnvelope<UserDeletedEvent> dee) {
		log.info("handleUserDeletedEvent() - UserHistoryEventHandlers - mdeforge-view-service");
	}
}
