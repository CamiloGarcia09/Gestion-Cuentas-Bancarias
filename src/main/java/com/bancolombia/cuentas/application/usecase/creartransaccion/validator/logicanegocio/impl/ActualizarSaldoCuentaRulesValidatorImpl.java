package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.ActualizarSaldoCuentaRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.ActualizarSaldoCuentaRule;
import org.springframework.stereotype.Service;

@Service
public final class ActualizarSaldoCuentaRulesValidatorImpl implements ActualizarSaldoCuentaRulesValidator {

    private final ActualizarSaldoCuentaRule actualizarSaldoCuentaRule;

    public ActualizarSaldoCuentaRulesValidatorImpl(final ActualizarSaldoCuentaRule actualizarSaldoCuentaRule) {
        this.actualizarSaldoCuentaRule = actualizarSaldoCuentaRule;
    }

    @Override
    public void validate(TransaccionDomain data) {
        actualizarSaldoCuentaRule.validate(data);
    }
}
