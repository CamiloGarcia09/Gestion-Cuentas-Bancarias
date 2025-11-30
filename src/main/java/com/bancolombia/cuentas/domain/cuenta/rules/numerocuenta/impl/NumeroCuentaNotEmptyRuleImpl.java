package com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta.NumeroCuentaEmptyException;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.NumeroCuentaNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public final class NumeroCuentaNotEmptyRuleImpl implements NumeroCuentaNotEmptyRule {

    @Override
    public void validate(CuentaDomain data) {
        if (TextHelper.isEmptyApplyingTrim(data.getNumeroCuenta())) {
            throw new NumeroCuentaEmptyException("El número de cuenta no puede estar vacío.");
        }
    }
}
