package com.bancolombia.cuentas.domain.cuenta.rules.id.impl;

import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesNotExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuentaIdDoesExistsRuleImplTest {

    private CuentaRepository cuentaRepository;
    private CuentaIdDoesExistsRuleImpl rule;

    @BeforeEach
    void setUp() {
        cuentaRepository = mock(CuentaRepository.class);
        rule = new CuentaIdDoesExistsRuleImpl(cuentaRepository);
    }

    @Test
    void validate_deberiaPasarCuandoExiste() {
        UUID id = UUID.randomUUID();
        when(cuentaRepository.existsById(id)).thenReturn(true);

        rule.validate(id);

        verify(cuentaRepository).existsById(id);
    }

    @Test
    void validate_deberiaLanzarExcepcionCuandoNoExiste() {
        UUID id = UUID.randomUUID();
        when(cuentaRepository.existsById(id)).thenReturn(false);

        assertThatThrownBy(() -> rule.validate(id))
                .isInstanceOf(CuentaIdDoesNotExistsException.class)
                .hasMessage("La cuenta no existe en el sistema");

        verify(cuentaRepository).existsById(id);
    }
}
