package com.bancolombia.cuentas.application.usecase.crearcuenta.validator.impl;

import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaNumeroCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.*;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaNumeroCuentaRulesValidatorImp implements CrearCuentaNumeroCuentaRulesValidator {

    private final NumeroCuentaDoesNotExistRule numeroCuentaDoesNotExistRule;
    private final NumeroCuentaFormatRule numeroCuentaFormatRule;
    private final NumeroCuentaLengthRule numeroCuentaLengthRule;
    private final NumeroCuentaNotEmptyRule numeroCuentaNotEmptyRule;
    private final NumeroCuentaNotNullRule numeroCuentaNotNullRule;

    public CrearCuentaNumeroCuentaRulesValidatorImp(final NumeroCuentaDoesNotExistRule numeroCuentaDoesNotExistRule,
                                                    final NumeroCuentaFormatRule numeroCuentaFormatRule,
                                                    final NumeroCuentaLengthRule numeroCuentaLengthRule,
                                                    final NumeroCuentaNotEmptyRule numeroCuentaNotEmptyRule,
                                                    final NumeroCuentaNotNullRule numeroCuentaNotNullRule) {
        this.numeroCuentaDoesNotExistRule = numeroCuentaDoesNotExistRule;
        this.numeroCuentaFormatRule = numeroCuentaFormatRule;
        this.numeroCuentaLengthRule = numeroCuentaLengthRule;
        this.numeroCuentaNotEmptyRule = numeroCuentaNotEmptyRule;
        this.numeroCuentaNotNullRule = numeroCuentaNotNullRule;
    }

    @Override
    public void validate(final CuentaDomain data) {
        numeroCuentaDoesNotExistRule.validate(data);
        numeroCuentaFormatRule.validate(data);
        numeroCuentaLengthRule.validate(data);
        numeroCuentaNotEmptyRule.validate(data);
        numeroCuentaNotNullRule.validate(data);
    }
}
