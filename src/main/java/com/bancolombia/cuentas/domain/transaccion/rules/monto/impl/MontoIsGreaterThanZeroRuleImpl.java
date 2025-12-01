package com.bancolombia.cuentas.domain.transaccion.rules.monto.impl;

import com.bancolombia.cuentas.crosscutting.helpers.NumericHelper;
import com.bancolombia.cuentas.domain.transaccion.exceptions.monto.MontoInvalidoException;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.MontoIsGreaterThanZeroRule;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public final class MontoIsGreaterThanZeroRuleImpl implements MontoIsGreaterThanZeroRule {

    @Override
    public void validate(BigDecimal monto) {
        if (monto == null || NumericHelper.isLessOrEqual(monto, BigDecimal.ZERO)) {
            throw new MontoInvalidoException("El monto debe ser mayor a cero.");
        }
    }
}
