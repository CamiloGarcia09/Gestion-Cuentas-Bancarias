package com.bancolombia.cuentas.application.usecase.creartransaccion.validator.impl;

import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransaccionIdRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.exceptions.id.TransaccionIdDoesExistsException;
import com.bancolombia.cuentas.domain.transaccion.rules.id.TransaccionIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearTransaccionIdRulesValidatorImpl implements CrearTransaccionIdRulesValidator {

    private final TransaccionIdDoesNotExistsRule transaccionIdDoesNotExistsRule;
    private final CuentaIdDoesExistsRule cuentaIdDoesExistsRule;

    public CrearTransaccionIdRulesValidatorImpl(final TransaccionIdDoesNotExistsRule transaccionIdDoesNotExistsRule,
                                                final CuentaIdDoesExistsRule cuentaIdDoesExistsRule) {
        this.transaccionIdDoesNotExistsRule = transaccionIdDoesNotExistsRule;
        this.cuentaIdDoesExistsRule = cuentaIdDoesExistsRule;
    }


    @Override
    public void validate(final TransaccionDomain data) {

        cuentaIdDoesExistsRule.validate(data.getCuenta().getId());

        try{
            data.generateId();
            transaccionIdDoesNotExistsRule.validate(data.getId());
        }catch (final TransaccionIdDoesExistsException exception){
            validate(data);
        }
    }
}
