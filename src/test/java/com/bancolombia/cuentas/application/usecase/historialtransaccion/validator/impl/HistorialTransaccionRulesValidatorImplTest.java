package com.bancolombia.cuentas.application.usecase.historialtransaccion.validator.impl;

import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class HistorialTransaccionRulesValidatorImplTest {

    private CuentaIdDoesExistsRule regla;
    private HistorialTransaccionRulesValidatorImpl validator;

    @BeforeEach
    void setUp() {
        regla = mock(CuentaIdDoesExistsRule.class);
        validator = new HistorialTransaccionRulesValidatorImpl(regla);
    }

    @Test
    void validate_deberiaEjecutarRegla() {
        UUID id = UUID.randomUUID();

        validator.validate(id);

        verify(regla).validate(id);
    }

    @Test
    void validate_deberiaPropagarExcepcion() {
        UUID id = UUID.randomUUID();

        doThrow(new RuntimeException("Cuenta no existe"))
                .when(regla).validate(id);

        try {
            validator.validate(id);
        } catch (RuntimeException e) {
            assert e.getMessage().equals("Cuenta no existe");
        }

        verify(regla).validate(id);
    }
}
