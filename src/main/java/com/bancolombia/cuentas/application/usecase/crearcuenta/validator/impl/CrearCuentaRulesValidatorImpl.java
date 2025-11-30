package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaIdRulesValidator;
import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaRulesValidatorImpl implements CrearCuentaRulesValidator {

    private final CrearCuentaIdRulesValidator crearCuentaIdRulesValidator;

    public CrearCuentaRulesValidatorImpl(final CrearCuentaIdRulesValidator crearCuentaIdRulesValidator) {
        this.crearCuentaIdRulesValidator = crearCuentaIdRulesValidator;
    }

    @Override
    public void validate(CuentaDomain data) {
        crearCuentaIdRulesValidator.validate(data);
    }
}
