package com.bancolombia.cuentas.domain.transaccion.rules.id.impl;

import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.domain.transaccion.exceptions.id.TransaccionIdDoesExistsException;
import com.bancolombia.cuentas.domain.transaccion.rules.id.TransaccionIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class TransaccionIdDoesNotExistsRuleImpl implements TransaccionIdDoesNotExistsRule {

    private final TransaccionRepository transaccionRepository;

    public TransaccionIdDoesNotExistsRuleImpl(final TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public void validate(UUID data) {
        if (transaccionRepository.existsById(data)) {
            throw new TransaccionIdDoesExistsException("La transaccion ya existe");
        }
    }
}
