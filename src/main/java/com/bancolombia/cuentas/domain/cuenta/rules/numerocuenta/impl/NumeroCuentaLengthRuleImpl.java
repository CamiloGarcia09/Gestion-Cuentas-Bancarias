package com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.impl;

import com.bancolombia.cuentas.crosscutting.helpers.NumericHelper;
import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta.NumeroCuentaLengthException;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.NumeroCuentaLengthRule;
import org.springframework.stereotype.Service;

@Service
public final class NumeroCuentaLengthRuleImpl implements NumeroCuentaLengthRule {

    @Override
    public void validate(CuentaDomain data) {

        final var numero = TextHelper.applyTrim(data.getNumeroCuenta());

        if (!NumericHelper.isBetween(numero.length(), 10, 12, true, true)) {
            throw new NumeroCuentaLengthException("El número de cuenta debe tener entre 10 y 12 caracteres.");
        }
    }
}
