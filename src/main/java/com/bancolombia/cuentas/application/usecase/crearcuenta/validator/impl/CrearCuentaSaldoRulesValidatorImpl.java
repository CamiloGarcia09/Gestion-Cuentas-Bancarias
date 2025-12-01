package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;


import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaSaldoRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.rules.saldo.SaldoInicialNotNullRule;
import com.bancolombia.cuentas.domain.cuenta.rules.saldo.SaldoInicialPositiveRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaSaldoRulesValidatorImpl implements CrearCuentaSaldoRulesValidator {

    private final SaldoInicialNotNullRule saldoInicialNotNullRule;
    private final SaldoInicialPositiveRule saldoInicialPositiveRule;

    public CrearCuentaSaldoRulesValidatorImpl(final SaldoInicialNotNullRule saldoInicialNotNullRule,
                                              final SaldoInicialPositiveRule saldoInicialPositiveRule) {
        this.saldoInicialNotNullRule = saldoInicialNotNullRule;
        this.saldoInicialPositiveRule = saldoInicialPositiveRule;
    }

    @Override
    public void validate(final CuentaDomain data) {
        saldoInicialNotNullRule.validate(data);
        saldoInicialPositiveRule.validate(data);
    }
}
