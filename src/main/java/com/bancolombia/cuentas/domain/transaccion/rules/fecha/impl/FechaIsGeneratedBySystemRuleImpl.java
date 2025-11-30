package com.bancolombia.cuentas.domain.transaccion.rules.fecha.impl;

import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.fecha.FechaIsGeneratedBySystemRule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public final class FechaIsGeneratedBySystemRuleImpl implements FechaIsGeneratedBySystemRule {

    @Override
    public void validate(TransaccionDomain domain) {
        domain.setFecha(LocalDateTime.now());
    }
}
