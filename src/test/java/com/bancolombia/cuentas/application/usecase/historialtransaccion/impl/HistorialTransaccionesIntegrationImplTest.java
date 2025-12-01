package com.bancolombia.cuentas.application.usecase.historialtransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.application.secondaryports.entity.TransaccionEntity;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;

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
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = MsGestionCuentasApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class HistorialTransaccionesIntegrationImplTest {

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

    @Autowired
    private TransaccionRepository transaccionRepository;

    private MockMvc mockMvc;
    private UUID cuentaId;

    @BeforeEach
    void setUp() {

        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        // Crear cuenta
        var cuenta = CuentaEntity.create(
                UUID.randomUUID(),
                "12345",
                "Juan",
                new BigDecimal("500000")
        );

        cuentaId = cuenta.getId();
        cuentaRepository.save(cuenta);

        // Crear transacciones
        var t1 = TransaccionEntity.create(
                UUID.randomUUID(),
                TipoTransaccion.DEPOSITO,
                "Ingreso de fondos",
                new BigDecimal("100000"),
                LocalDateTime.now().minusDays(1),
                cuenta
        );

        var t2 = TransaccionEntity.create(
                UUID.randomUUID(),
                TipoTransaccion.RETIRO,
                "Pago de servicios",
                new BigDecimal("50000"),
                LocalDateTime.now(),
                cuenta
        );

        transaccionRepository.save(t1);
        transaccionRepository.save(t2);
    }

    @Test
    void deberiaRetornarHistoricoDeTransacciones() throws Exception {

        mockMvc.perform(get("/api/v1/{id}/transacciones", cuentaId))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.datos.length()").value(2))
                .andExpect(jsonPath("$.datos[0].descripcion").exists())
                .andExpect(jsonPath("$.datos[0].monto").exists())
                .andExpect(jsonPath("$.datos[0].tipoTransaccion").exists());
    }
}
