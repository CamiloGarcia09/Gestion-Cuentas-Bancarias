package com.bancolombia.cuentas.application.usecase.crearcuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.usecase.crearcuenta.CrearCuenta;
import com.bancolombia.cuentas.application.usecase.crearcuenta.validator.CrearCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

@Service
public final class CrearCuentaImpl implements CrearCuenta {

    private final CuentaEntityMapper cuentaEntityMapper;
    private final CuentaRepository cuentaRepository;
    private final CrearCuentaRulesValidator crearCuentaRulesValidator;

    public CrearCuentaImpl(final CuentaEntityMapper cuentaEntityMapper, final CuentaRepository cuentaRepository,
                           final CrearCuentaRulesValidator crearCuentaRulesValidator) {
        this.cuentaEntityMapper = cuentaEntityMapper;
        this.cuentaRepository = cuentaRepository;
        this.crearCuentaRulesValidator = crearCuentaRulesValidator;
    }

    @Override
    public void execute(CuentaDomain domain) {
        crearCuentaRulesValidator.validate(domain);

        final var cuentaEntity = cuentaEntityMapper.toEntity(domain);
        cuentaRepository.save(cuentaEntity);
    }
}
