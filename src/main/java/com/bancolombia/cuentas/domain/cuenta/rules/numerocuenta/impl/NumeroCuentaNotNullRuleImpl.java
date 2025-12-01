package com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta.NumeroCuentaNullException;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.NumeroCuentaNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class NumeroCuentaNotNullRuleImpl implements NumeroCuentaNotNullRule {

    @Override
    public void validate(CuentaDomain data) {
        if (TextHelper.isNull(data.getNumeroCuenta())) {
            throw new NumeroCuentaNullException("El número de cuenta no puede ser nulo.");
        }
    }
}
