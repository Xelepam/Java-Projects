package com.springdatarest.eventmanagement.eventmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
// @EntityScan is used so we can configure java.time.* support - JPA provider : Hibernate does not support
// java.time by default so you need to do 3 additional steps:
// 1. Upgrade Hibernate
// 2. Add Jackson JSR310 dependency (Oracle specification that deals with all the java.time related
// classes)
// 3. Use a Converter to deal with these classes (done via the @EntityScan annotation)
@EntityScan(basePackageClasses = { EventManagementApiApplication.class, Jsr310Converters.class })
public class EventManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApiApplication.class, args);
	}

}
