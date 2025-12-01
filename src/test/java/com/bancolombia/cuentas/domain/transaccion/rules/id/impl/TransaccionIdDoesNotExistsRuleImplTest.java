package com.bancolombia.cuentas.domain.transaccion.rules.id.impl;


import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.domain.transaccion.exceptions.id.TransaccionIdDoesExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransaccionIdDoesNotExistsRuleImplTest {

    private TransaccionRepository repo;
    private TransaccionIdDoesNotExistsRuleImpl rule;

    @BeforeEach
    void setUp() {
        repo = mock(TransaccionRepository.class);
        rule = new TransaccionIdDoesNotExistsRuleImpl(repo);
    }

    @Test
    void validate_noDebeLanzarCuandoIdNoExiste() {
        UUID id = UUID.randomUUID();

        when(repo.existsById(id)).thenReturn(false);

        rule.validate(id);

        verify(repo).existsById(id);
    }

    @Test
    void validate_debeLanzarExcepcionCuandoIdExiste() {
        UUID id = UUID.randomUUID();

        when(repo.existsById(id)).thenReturn(true);

        assertThatThrownBy(() -> rule.validate(id))
                .isInstanceOf(TransaccionIdDoesExistsException.class)
                .hasMessage("La transaccion ya existe");

        verify(repo).existsById(id);
    }
}