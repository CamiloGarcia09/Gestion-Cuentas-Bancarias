package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaIdValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaIdRulesValidatorImpl implements CrearCuentaIdValidator {

    @Override
    public void validate(CuentaDomain data) {
        data.generateId();
    }
}
