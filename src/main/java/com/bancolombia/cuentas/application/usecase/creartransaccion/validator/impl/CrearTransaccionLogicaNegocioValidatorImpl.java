package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionLogicaNegocioValidator;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.ActualizarSaldoCuentaRulesValidator;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.FechaIsGeneratedBySystemRuleValidator;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.logicanegocio.SaldoDisponibleRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionLogicaNegocioValidatorImpl implements CrearTransaccionLogicaNegocioValidator {

    private final ActualizarSaldoCuentaRulesValidator actualizarSaldoCuentaRulesValidator;
    private final FechaIsGeneratedBySystemRuleValidator fechaIsGeneratedBySystemRuleValidator;
    private final SaldoDisponibleRulesValidator saldoDisponibleRulesValidator;

    public CrearTransaccionLogicaNegocioValidatorImpl(final ActualizarSaldoCuentaRulesValidator actualizarSaldoCuentaRulesValidator,
                                                      final FechaIsGeneratedBySystemRuleValidator fechaIsGeneratedBySystemRuleValidator,
                                                      final SaldoDisponibleRulesValidator saldoDisponibleRulesValidator) {
        this.actualizarSaldoCuentaRulesValidator = actualizarSaldoCuentaRulesValidator;
        this.fechaIsGeneratedBySystemRuleValidator = fechaIsGeneratedBySystemRuleValidator;
        this.saldoDisponibleRulesValidator = saldoDisponibleRulesValidator;
    }

    @Override
    public void validate(TransaccionDomain data) {
        saldoDisponibleRulesValidator.validate(data);
        actualizarSaldoCuentaRulesValidator.validate(data);
        fechaIsGeneratedBySystemRuleValidator.validate(data);
    }
}
