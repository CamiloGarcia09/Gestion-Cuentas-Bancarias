package com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.impl;

import com.bancolombia.cuentas.crosscutting.helpers.NumericHelper;
import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular.NombreTitularLengthException;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularLengthRule;
import org.springframework.stereotype.Service;

@Service
public final class NombreTitularLengthRuleImpl implements NombreTitularLengthRule {

    @Override
    public void validate(CuentaDomain data) {

        final var nombre = TextHelper.applyTrim(data.getNombreTitular());

        if (!NumericHelper.isBetween(nombre.length(), 3, 50, true, true)) {
            throw new NombreTitularLengthException("El nombre debe tener entre 3 y 50 caracteres.");
        }
    }

}
