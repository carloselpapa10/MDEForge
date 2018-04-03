package org.mdeforge.projectservice;

import org.mdeforge.projectservice.commandhandlers.ProjectServiceCommandHandlersConfiguration;
import org.mdeforge.projectservice.dao.ProjectServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({ProjectServiceConfiguration.class,
	ProjectServiceCommandHandlersConfiguration.class,
	TramJdbcKafkaConfiguration.class})
public class ProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}
}
