package com.bancolombia.cuentas.domain.cuenta.rules.id.impl;

import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesNotExistsException;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CuentaIdDoesExistsRuleImpl implements CuentaIdDoesExistsRule {

    private final CuentaRepository cuentaRepository;

    public CuentaIdDoesExistsRuleImpl(final CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void validate(UUID data) {
        if (!cuentaRepository.existsById(data)) {
            throw new CuentaIdDoesNotExistsException("La cuenta no existe en el sistema");
        }
    }
}
