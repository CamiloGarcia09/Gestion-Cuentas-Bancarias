package com.bancolombia.cuentas.domain.transaccion.rules.descripcion.impl;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.exceptions.descripcion.DescripcionVaciaException;
import com.bancolombia.cuentas.domain.transaccion.rules.descripcion.DescripcionIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public final class DescripcionIsNotEmptyRuleImpl implements DescripcionIsNotEmptyRule {

    @Override
    public void validate(TransaccionDomain descripcion) {
        if (TextHelper.isEmptyApplyingTrim(descripcion.getDescripcion())) {
            throw new DescripcionVaciaException("La descripción no puede estar vacía.");
        }
    }
}
