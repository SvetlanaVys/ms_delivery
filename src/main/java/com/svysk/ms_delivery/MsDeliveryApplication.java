package com.svysk.ms_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MsDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDeliveryApplication.class, args);
	}

}
