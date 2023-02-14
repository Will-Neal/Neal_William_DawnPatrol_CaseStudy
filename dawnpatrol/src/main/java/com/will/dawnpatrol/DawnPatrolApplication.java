package com.will.dawnpatrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.will.dawnpatrol.model"})
public class DawnPatrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DawnPatrolApplication.class, args);
	}

}
