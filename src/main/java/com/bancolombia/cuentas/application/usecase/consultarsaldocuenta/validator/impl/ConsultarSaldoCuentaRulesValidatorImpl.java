package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.validator.ConsultarSaldoCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsultarSaldoCuentaRulesValidatorImpl implements ConsultarSaldoCuentaRulesValidator {

    private final CuentaIdDoesExistsRule cuentaIdDoesExistsRule;

    public ConsultarSaldoCuentaRulesValidatorImpl(final CuentaIdDoesExistsRule cuentaIdDoesExistsRule) {
        this.cuentaIdDoesExistsRule = cuentaIdDoesExistsRule;
    }

    @Override
    public void validate(UUID data) {
        cuentaIdDoesExistsRule.validate(data);
    }
}
