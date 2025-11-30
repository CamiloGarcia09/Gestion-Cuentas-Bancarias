package com.bancolombia.cuentas.application.usecase.creartransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.mapper.TransaccionEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.application.usecase.creartransaccion.CrearTransaccion;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransasccionRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesExistsException;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;


@Service
public final class CrearTransaccionImpl implements CrearTransaccion {

    private final TransaccionEntityMapper transaccionEntityMapper;
    private final TransaccionRepository transaccionRepository;
    private final CuentaEntityMapper cuentaEntityMapper;
    private final CuentaRepository cuentaRepository;
    private final CrearTransasccionRulesValidator crearTransasccionRulesValidator;

    public CrearTransaccionImpl(final TransaccionEntityMapper transaccionEntityMapper,
                                final TransaccionRepository transaccionRepository,
                                final CuentaEntityMapper cuentaEntityMapper,
                                final CuentaRepository cuentaRepository,
                                final CrearTransasccionRulesValidator crearTransasccionRulesValidator) {
        this.transaccionEntityMapper = transaccionEntityMapper;
        this.transaccionRepository = transaccionRepository;
        this.cuentaEntityMapper = cuentaEntityMapper;
        this.cuentaRepository = cuentaRepository;
        this.crearTransasccionRulesValidator = crearTransasccionRulesValidator;
    }

    @Override
    public void execute(TransaccionDomain domain) {

        var cuenta = cuentaRepository.findById(domain.getCuenta().getId())
                .orElseThrow(() -> new CuentaIdDoesExistsException("Cuenta no encontrada"));

        final var cuentaDomain = cuentaEntityMapper.toDomain(cuenta);
        domain.asignarCuenta(cuentaDomain);

        crearTransasccionRulesValidator.validate(domain);

        final var transaccionEntity = transaccionEntityMapper.toEntity(domain);
        transaccionRepository.save(transaccionEntity);

        var cuentaActualizadaEntity = cuentaEntityMapper.toEntity(domain.getCuenta());
        cuentaRepository.save(cuentaActualizadaEntity);
    }
}

