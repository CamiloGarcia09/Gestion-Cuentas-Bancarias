package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionMontoRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.MontoIsGreaterThanZeroRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionMontoRulesValidatorImpl implements CrearTransaccionMontoRulesValidator {

    private final MontoIsGreaterThanZeroRule montoIsGreaterThanZeroRule;

    public CrearTransaccionMontoRulesValidatorImpl(final MontoIsGreaterThanZeroRule montoIsGreaterThanZeroRule) {
        this.montoIsGreaterThanZeroRule = montoIsGreaterThanZeroRule;
    }

    @Override
    public void validate(final TransaccionDomain data) {
        montoIsGreaterThanZeroRule.validate(data.getMonto());
    }
}
