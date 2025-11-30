package com.bancolombia.cuentas.domain.transaccion.rules;

import com.bancolombia.cuentas.domain.DomainRule;

import java.util.UUID;

public interface TransaccionIdDoesNotExistsRule extends DomainRule<UUID> {
}
