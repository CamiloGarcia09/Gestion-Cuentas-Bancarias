package com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta.NumeroCuentaFormatException;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.NumeroCuentaFormatRule;
import org.springframework.stereotype.Service;

@Service
public final class NumeroCuentaFormatRuleImpl implements NumeroCuentaFormatRule {

    @Override
    public void validate(CuentaDomain data) {
        if (!TextHelper.applyTrim(data.getNumeroCuenta()).matches("\\d+")) {
            throw new NumeroCuentaFormatException("El número de cuenta solo puede contener dígitos.");
        }
    }
}
