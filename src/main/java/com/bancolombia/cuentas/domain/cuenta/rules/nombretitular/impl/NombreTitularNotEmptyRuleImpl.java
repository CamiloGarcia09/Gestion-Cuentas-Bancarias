package com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular.NombreTitularEmptyException;
import com.bancolombia.cuentas.domain.cuenta.rules.nombretitular.NombreTitularNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public final class NombreTitularNotEmptyRuleImpl implements NombreTitularNotEmptyRule {

    @Override
    public void validate(CuentaDomain data) {
        if (TextHelper.isEmptyApplyingTrim(data.getNombreTitular())) {
            throw new NombreTitularEmptyException("El nombre del titular no puede estar vacío.");
        }
    }
}
