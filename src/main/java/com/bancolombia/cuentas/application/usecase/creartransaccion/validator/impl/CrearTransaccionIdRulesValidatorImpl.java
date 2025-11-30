package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionIdRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionIdRulesValidatorImpl implements CrearTransaccionIdRulesValidator {


    @Override
    public void validate(TransaccionDomain data) {
        data.generateId();
    }
}
