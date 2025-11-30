package com.bancolombia.cuentas.domain.cuenta.rules.id.impl;

import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesExistsException;
import com.bancolombia.cuentas.domain.cuenta.rules.id.CuentaIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CuentaIdDoesNotExistsRuleImpl implements CuentaIdDoesNotExistsRule {

    private final CuentaRepository cuentaRepository;

    public CuentaIdDoesNotExistsRuleImpl(final CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void validate(UUID data) {
        if (cuentaRepository.existsById(data)) {
            throw new CuentaIdDoesExistsException("La cuenta ya existe");
        }
    }
}
