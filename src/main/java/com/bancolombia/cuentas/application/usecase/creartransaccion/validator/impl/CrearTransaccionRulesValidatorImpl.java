package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionIdRulesValidator;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransasccionRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionRulesValidatorImpl implements CrearTransasccionRulesValidator {

    private final CrearTransaccionIdRulesValidator crearTransaccionIdRulesValidator;

    public CrearTransaccionRulesValidatorImpl(CrearTransaccionIdRulesValidator crearTransaccionIdRulesValidator) {
        this.crearTransaccionIdRulesValidator = crearTransaccionIdRulesValidator;
    }

    @Override
    public void validate(TransaccionDomain data) {
        crearTransaccionIdRulesValidator.validate(data);
    }
}
