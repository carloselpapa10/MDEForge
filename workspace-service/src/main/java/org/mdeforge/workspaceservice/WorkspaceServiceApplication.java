package org.mdeforge.workspaceservice;

import org.mdeforge.workspaceservice.commandhandlers.WorkspaceServiceCommandHandlersConfiguration;
import org.mdeforge.workspaceservice.dao.WorkspaceServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({WorkspaceServiceConfiguration.class,
	WorkspaceServiceCommandHandlersConfiguration.class,
	TramJdbcKafkaConfiguration.class})
public class WorkspaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceServiceApplication.class, args);
	}
}
