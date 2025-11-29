package com.bancolombia.cuentas.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bancolombia.cuentas"})
@EntityScan(basePackages = {"com.bancolombia.cuentas.application.secondaryports.entity"})
@EnableJpaRepositories(basePackages = {"com.bancolombia.cuentas"})
public class MsGestionCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionCuentasApplication.class, args);
	}

}
