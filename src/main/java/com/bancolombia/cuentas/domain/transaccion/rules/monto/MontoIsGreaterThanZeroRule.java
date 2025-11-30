package com.bancolombia.cuentas.domain.transaccion.rules.monto;

import com.bancolombia.cuentas.domain.DomainRule;

import java.math.BigDecimal;

public interface MontoIsGreaterThanZeroRule extends DomainRule<BigDecimal> {
}
