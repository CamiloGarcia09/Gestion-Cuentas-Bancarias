package com.bancolombia.cuentas.application.usecase.historialtransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.historialtransaccion.validator.HistorialTransaccionRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class HistorialTransaccionRulesValidatorImpl implements HistorialTransaccionRulesValidator {

    private final CuentaIdDoesExistsRule cuentaIdDoesExistsRule;

    public HistorialTransaccionRulesValidatorImpl(final CuentaIdDoesExistsRule cuentaIdDoesExistsRule) {
        this.cuentaIdDoesExistsRule = cuentaIdDoesExistsRule;
    }

    @Override
    public void validate(UUID data) {
        cuentaIdDoesExistsRule.validate(data);
    }
}
