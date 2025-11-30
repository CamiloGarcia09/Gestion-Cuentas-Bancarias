package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.*;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaRulesValidatorImpl implements CrearCuentaRulesValidator {

    private final CrearCuentaIdRulesValidator crearCuentaIdRulesValidator;
    private final CrearCuentaNumeroCuentaRulesValidator crearCuentaNumeroCuentaRulesValidator;
    private final CrearCuentaNombreTitularRulesValidator crearCuentaNombreTitularRulesValidator;
    private final CrearCuentaSaldoRulesValidator crearCuentaSaldoRulesValidator;

    public CrearCuentaRulesValidatorImpl(final CrearCuentaIdRulesValidator crearCuentaIdRulesValidator,
                                         final CrearCuentaNumeroCuentaRulesValidator crearCuentaNumeroCuentaRulesValidator,
                                         final CrearCuentaNombreTitularRulesValidator crearCuentaNombreTitularRulesValidator,
                                         final CrearCuentaSaldoRulesValidator crearCuentaSaldoRulesValidator) {
        this.crearCuentaIdRulesValidator = crearCuentaIdRulesValidator;
        this.crearCuentaNumeroCuentaRulesValidator = crearCuentaNumeroCuentaRulesValidator;
        this.crearCuentaNombreTitularRulesValidator = crearCuentaNombreTitularRulesValidator;
        this.crearCuentaSaldoRulesValidator = crearCuentaSaldoRulesValidator;
    }

    @Override
    public void validate(final CuentaDomain data) {
        crearCuentaIdRulesValidator.validate(data);
        crearCuentaNumeroCuentaRulesValidator.validate(data);
        crearCuentaNombreTitularRulesValidator.validate(data);
        crearCuentaSaldoRulesValidator.validate(data);
    }
}
