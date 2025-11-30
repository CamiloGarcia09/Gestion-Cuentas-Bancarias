package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaNombreTitularRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularFormatRule;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularLengthRule;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularNotEmptyRule;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaNombreTitularRulesValidatorImpl implements CrearCuentaNombreTitularRulesValidator {

    private final NombreTitularFormatRule nombreTitularFormatRule;
    private final NombreTitularLengthRule nombreTitularLengthRule;
    private final NombreTitularNotEmptyRule nombreTitularNotEmptyRule;
    private final NombreTitularNotNullRule nombreTitularNotNullRule;

    public CrearCuentaNombreTitularRulesValidatorImpl(final NombreTitularFormatRule nombreTitularFormatRule,
                                                      final NombreTitularLengthRule nombreTitularLengthRule,
                                                      final NombreTitularNotEmptyRule nombreTitularNotEmptyRule,
                                                      final NombreTitularNotNullRule nombreTitularNotNullRule) {
        this.nombreTitularFormatRule = nombreTitularFormatRule;
        this.nombreTitularLengthRule = nombreTitularLengthRule;
        this.nombreTitularNotEmptyRule = nombreTitularNotEmptyRule;
        this.nombreTitularNotNullRule = nombreTitularNotNullRule;
    }

    @Override
    public void validate(final CuentaDomain data) {
        nombreTitularFormatRule.validate(data);
        nombreTitularLengthRule.validate(data);
        nombreTitularNotEmptyRule.validate(data);
        nombreTitularNotNullRule.validate(data);
    }
}
