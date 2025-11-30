package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionTipoTransaccionRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.tipotransaccion.TipoTransaccionIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionTipoTransaccionRulesValidatorImpl implements CrearTransaccionTipoTransaccionRulesValidator {

    private final TipoTransaccionIsNotNullRule tipoTransaccionIsNotNullRule;

    public CrearTransaccionTipoTransaccionRulesValidatorImpl(final TipoTransaccionIsNotNullRule tipoTransaccionIsNotNullRule) {
        this.tipoTransaccionIsNotNullRule = tipoTransaccionIsNotNullRule;
    }

    @Override
    public void validate(TransaccionDomain data) {
        tipoTransaccionIsNotNullRule.validate(data.getTipoTransaccion());
    }
}
