package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaIdRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaIdRulesValidatorImpl implements CrearCuentaIdRulesValidator {

    @Override
    public void validate(CuentaDomain data) {
        data.generateId();
    }
}
