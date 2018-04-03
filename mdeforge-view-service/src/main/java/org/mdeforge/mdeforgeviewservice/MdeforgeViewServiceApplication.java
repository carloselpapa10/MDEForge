package org.mdeforge.mdeforgeviewservice;

import org.mdeforge.mdeforgeviewservice.messaging.EventHandlersConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({EventHandlersConfiguration.class, TramJdbcKafkaConfiguration.class})
public class MdeforgeViewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdeforgeViewServiceApplication.class, args);
	}
}
