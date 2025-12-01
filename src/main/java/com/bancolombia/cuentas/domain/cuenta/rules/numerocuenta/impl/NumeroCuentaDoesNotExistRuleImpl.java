package com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta.NumeroCuentaAlreadyExistsException;
import com.bancolombia.cuentas.domain.cuenta.rules.numerocuenta.NumeroCuentaDoesNotExistRule;
import org.springframework.stereotype.Service;

@Service
public final class NumeroCuentaDoesNotExistRuleImpl implements NumeroCuentaDoesNotExistRule {

    private final CuentaRepository cuentaRepository;

    public NumeroCuentaDoesNotExistRuleImpl(final CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void validate(CuentaDomain data) {

        if (cuentaRepository.existsByNumeroCuenta(data.getNumeroCuenta())) {
            throw new NumeroCuentaAlreadyExistsException("El número de cuenta ya existe.");
        }
    }
}
