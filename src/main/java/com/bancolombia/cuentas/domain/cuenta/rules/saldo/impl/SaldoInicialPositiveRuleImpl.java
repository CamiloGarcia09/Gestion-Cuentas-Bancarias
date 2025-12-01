package com.bancolombia.cuentas.domain.cuenta.rules.saldo.impl;

import com.bancolombia.cuentas.crosscutting.helpers.NumericHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.saldo.SaldoInicialNegativeException;
import com.bancolombia.cuentas.domain.cuenta.rules.saldo.SaldoInicialPositiveRule;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public final class SaldoInicialPositiveRuleImpl implements SaldoInicialPositiveRule {

    @Override
    public void validate(CuentaDomain data) {
        if (NumericHelper.isLess(data.getSaldo(), BigDecimal.ZERO)) {
            throw new SaldoInicialNegativeException("El saldo inicial no puede ser negativo.");
        }
    }
}
