package com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular.NombreTitularNullException;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class NombreTitularNotNullRuleImpl implements NombreTitularNotNullRule {

    @Override
    public void validate(CuentaDomain data) {
        if (TextHelper.isNull(data.getNombreTitular())) {
            throw new NombreTitularNullException("El nombre del titular no puede ser nulo.");
        }
    }
}
