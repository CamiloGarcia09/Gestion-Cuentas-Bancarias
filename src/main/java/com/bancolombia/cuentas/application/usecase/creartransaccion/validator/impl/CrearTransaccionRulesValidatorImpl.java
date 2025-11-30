package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.*;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionRulesValidatorImpl implements CrearTransasccionRulesValidator {

    private final CrearTransaccionIdRulesValidator crearTransaccionIdRulesValidator;
    private final CrearTransaccionDescripcionRulesValidator crearTransaccionDescripcionRulesValidator;
    private final CrearTransaccionLogicaNegocioValidator crearTransaccionLogicaNegocioValidator;
    private final CrearTransaccionMontoRulesValidator crearTransaccionMontoRulesValidator;
    private final CrearTransaccionTipoTransaccionRulesValidator crearTransaccionTipoTransaccionRulesValidator;

    public CrearTransaccionRulesValidatorImpl(final CrearTransaccionIdRulesValidator crearTransaccionIdRulesValidator,
                                              final CrearTransaccionDescripcionRulesValidator crearTransaccionDescripcionRulesValidator,
                                              final CrearTransaccionLogicaNegocioValidator crearTransaccionLogicaNegocioValidator,
                                              final CrearTransaccionMontoRulesValidator crearTransaccionMontoRulesValidator,
                                              final CrearTransaccionTipoTransaccionRulesValidator crearTransaccionTipoTransaccionRulesValidator) {
        this.crearTransaccionIdRulesValidator = crearTransaccionIdRulesValidator;
        this.crearTransaccionDescripcionRulesValidator = crearTransaccionDescripcionRulesValidator;
        this.crearTransaccionLogicaNegocioValidator = crearTransaccionLogicaNegocioValidator;
        this.crearTransaccionMontoRulesValidator = crearTransaccionMontoRulesValidator;
        this.crearTransaccionTipoTransaccionRulesValidator = crearTransaccionTipoTransaccionRulesValidator;
    }

    @Override
    public void validate(final TransaccionDomain data) {
        crearTransaccionIdRulesValidator.validate(data);
        crearTransaccionDescripcionRulesValidator.validate(data);
        crearTransaccionLogicaNegocioValidator.validate(data);
        crearTransaccionMontoRulesValidator.validate(data);
        crearTransaccionTipoTransaccionRulesValidator.validate(data);
    }
}
