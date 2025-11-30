package com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular.NombreTitularFormatException;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularFormatRule;
import org.springframework.stereotype.Service;

@Service
public final class NombreTitularFormatRuleImpl implements NombreTitularFormatRule {

    @Override
    public void validate(CuentaDomain data) {
        if (!TextHelper.containsOnlyLetters(data.getNombreTitular())) {
            throw new NombreTitularFormatException("El nombre del titular solo puede contener letras y espacios.");
        }
    }

}
