package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.initializer.MsGestionCuentasApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = MsGestionCuentasApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class ConsultarSaldoCuentaIntegrationImplTest {

    @Container
    private static final PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>("postgres:15")
                    .withDatabaseName("testdb")
                    .withUsername("test")
                    .withPassword("test");

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CuentaRepository cuentaRepository;

    private MockMvc mockMvc;
    private UUID cuentaId;

    @BeforeEach
    void setUp() {

        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        var cuenta = CuentaEntity.create(
                UUID.randomUUID(),
                "12345",
                "Juan",
                BigDecimal.TEN
        );

        cuentaId = cuenta.getId();
        cuentaRepository.save(cuenta);
    }

    @Test
    void deberiaRetornarSaldoCorrecto() throws Exception {

        mockMvc.perform(get("/api/v1/cuentas/{id}/saldo", cuentaId))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.datos[0].nombreTitular").value("Juan"))
                .andExpect(jsonPath("$.datos[0].saldo").value(10));
    }
}
