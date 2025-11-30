package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.SaldoDisponibleRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.SaldoDisponibleRule;
import org.springframework.stereotype.Service;

@Service
public final class SaldoDisponibleRulesValidatorImpl implements SaldoDisponibleRulesValidator {

    private final SaldoDisponibleRule saldoDisponibleRule;

    public SaldoDisponibleRulesValidatorImpl(final SaldoDisponibleRule saldoDisponibleRule) {
        this.saldoDisponibleRule = saldoDisponibleRule;
    }

    @Override
    public void validate(TransaccionDomain data) {
        saldoDisponibleRule.validate(data);
    }
}
