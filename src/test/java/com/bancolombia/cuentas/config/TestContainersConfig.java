package com.bancolombia.cuentas.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public class TestContainersConfig {

    @Bean
    public PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> container =
                new PostgreSQLContainer<>("postgres:15")
                        .withDatabaseName("test_db")
                        .withUsername("test")
                        .withPassword("test");

        container.start();
        return container;
    }
}