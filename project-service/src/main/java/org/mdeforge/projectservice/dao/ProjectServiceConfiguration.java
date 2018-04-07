package org.mdeforge.projectservice.dao;

import org.mdeforge.projectservice.saga.createproject.CreateProjectSaga;
import org.mdeforge.projectservice.saga.createproject.CreateProjectSagaData;
import org.mdeforge.projectservice.saga.deleteproject.DeleteProjectSaga;
import org.mdeforge.projectservice.saga.deleteproject.DeleteProjectSagaData;
import org.mdeforge.projectservice.saga.updateproject.UpdateProjectSaga;
import org.mdeforge.projectservice.saga.updateproject.UpdateProjectSagaData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;

@Configuration
@Import({TramEventsPublisherConfiguration.class, SagaOrchestratorConfiguration.class })
public class ProjectServiceConfiguration {

	@Bean
	public ChannelMapping channelMapping() {
	    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
	}
	
	@Bean
	public SagaManager<CreateProjectSagaData> createProjectSagaManager(CreateProjectSaga saga){
		return new SagaManagerImpl<>(saga);
	}
	
	@Bean
	public SagaManager<UpdateProjectSagaData> updateSagaManager(UpdateProjectSaga saga){
		return new SagaManagerImpl<>(saga);
	}
	
	@Bean
	public SagaManager<DeleteProjectSagaData> deleteSagaManager(DeleteProjectSaga saga){
		return new SagaManagerImpl<>(saga);
	}
}
