package com.bancolombia.cuentas.application.usecase.crearcuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;

class CrearCuentaImplTest {

    private CuentaEntityMapper mapper;
    private CuentaRepository repository;
    private CrearCuentaRulesValidator rulesValidator;
    private CrearCuentaImpl useCase;

    @BeforeEach
    void setUp() {
        mapper = mock(CuentaEntityMapper.class);
        repository = mock(CuentaRepository.class);
        rulesValidator = mock(CrearCuentaRulesValidator.class);

        useCase = new CrearCuentaImpl(mapper, repository, rulesValidator);
    }

    @Test
    void execute_deberiaValidarMapearYGuardar() {

        var domain = CuentaDomain.create(
                UUID.randomUUID(),
                "12345",
                "Juan",
                BigDecimal.TEN
        );

        var entity = com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity
                .create(domain.getId(), "12345", "Juan", BigDecimal.TEN);

        when(mapper.toEntity(domain)).thenReturn(entity);

        useCase.execute(domain);

        verify(rulesValidator, times(1)).validate(domain);
        verify(mapper, times(1)).toEntity(domain);
        verify(repository, times(1)).save(entity);

        verifyNoMoreInteractions(rulesValidator, mapper, repository);
    }
}