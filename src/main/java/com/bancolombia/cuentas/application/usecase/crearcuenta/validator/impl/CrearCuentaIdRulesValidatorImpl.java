package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaIdRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesExistsException;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaIdRulesValidatorImpl implements CrearCuentaIdRulesValidator {

    private final CuentaIdDoesNotExistsRule cuentaIdDoesNotExistsRule;

    public CrearCuentaIdRulesValidatorImpl(final CuentaIdDoesNotExistsRule cuentaIdDoesNotExistsRule) {
        this.cuentaIdDoesNotExistsRule = cuentaIdDoesNotExistsRule;
    }

    @Override
    public void validate(final CuentaDomain data) {
        try{
            data.generateId();
            cuentaIdDoesNotExistsRule.validate(data.getId());
        }catch (final CuentaIdDoesExistsException exception){
            validate(data);
        }
    }
}
