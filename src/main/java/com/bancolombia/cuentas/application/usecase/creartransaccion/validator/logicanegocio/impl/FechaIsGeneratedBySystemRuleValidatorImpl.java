package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.FechaIsGeneratedBySystemRuleValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.fecha.FechaIsGeneratedBySystemRule;
import org.springframework.stereotype.Service;

@Service
public final class FechaIsGeneratedBySystemRuleValidatorImpl implements FechaIsGeneratedBySystemRuleValidator {

    private final FechaIsGeneratedBySystemRule fechaIsGeneratedBySystemRule;

    public FechaIsGeneratedBySystemRuleValidatorImpl(final FechaIsGeneratedBySystemRule fechaIsGeneratedBySystemRule) {
        this.fechaIsGeneratedBySystemRule = fechaIsGeneratedBySystemRule;
    }

    @Override
    public void validate(final TransaccionDomain data) {
        fechaIsGeneratedBySystemRule.validate(data);
    }
}
