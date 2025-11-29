package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaIdValidator;
import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaRulesValidatorImpl implements CrearCuentaRulesValidator {

    private final CrearCuentaIdValidator crearCuentaIdValidator;

    public CrearCuentaRulesValidatorImpl(final CrearCuentaIdValidator crearCuentaIdValidator) {
        this.crearCuentaIdValidator = crearCuentaIdValidator;
    }

    @Override
    public void validate(CuentaDomain data) {
        crearCuentaIdValidator.validate(data);
    }
}
