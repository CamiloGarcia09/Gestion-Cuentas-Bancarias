package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionDescripcionRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.descripcion.DescripcionIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionDescripcionRulesValidatorImpl implements CrearTransaccionDescripcionRulesValidator {

    private final DescripcionIsNotEmptyRule descripcionIsNotEmptyRule;

    public CrearTransaccionDescripcionRulesValidatorImpl(final DescripcionIsNotEmptyRule descripcionIsNotEmptyRule) {
        this.descripcionIsNotEmptyRule = descripcionIsNotEmptyRule;
    }

    @Override
    public void validate(final TransaccionDomain data) {
        descripcionIsNotEmptyRule.validate(data);
    }
}
