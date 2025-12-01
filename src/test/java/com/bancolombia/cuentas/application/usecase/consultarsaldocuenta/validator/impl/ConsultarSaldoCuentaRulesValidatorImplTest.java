package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.validator.impl;

import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class ConsultarSaldoCuentaRulesValidatorImplTest {

    private CuentaIdDoesExistsRule rule;
    private ConsultarSaldoCuentaRulesValidatorImpl validator;

    @BeforeEach
    void setUp() {
        rule = mock(CuentaIdDoesExistsRule.class);
        validator = new ConsultarSaldoCuentaRulesValidatorImpl(rule);
    }

    @Test
    void validate_deberiaLlamarRegla() {
        UUID id = UUID.randomUUID();

        validator.validate(id);

        verify(rule).validate(id);
    }

    @Test
    void validate_deberiaPropagarExcepcion() {
        UUID id = UUID.randomUUID();

        doThrow(new RuntimeException("Error regla"))
                .when(rule).validate(id);

        try {
            validator.validate(id);
        } catch (RuntimeException ex) {
            assert ex.getMessage().equals("Error regla");
        }

        verify(rule).validate(id);
    }
}
