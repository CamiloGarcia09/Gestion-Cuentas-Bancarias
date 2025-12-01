package com.bancolombia.cuentas.domain.cuenta.rules.saldo.impl;

import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.saldo.SaldoInicialNullException;
import com.bancolombia.cuentas.domain.cuenta.rules.saldo.SaldoInicialNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class SaldoInicialNotNullRuleImpl implements SaldoInicialNotNullRule {

    @Override
    public void validate(CuentaDomain data) {
        if (data.getSaldo() == null) {
            throw new SaldoInicialNullException("El saldo inicial no puede ser nulo.");
        }
    }
}
