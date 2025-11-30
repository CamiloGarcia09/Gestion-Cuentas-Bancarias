package com.bancolombia.cuentas.application.usecase.creartransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.TransaccionEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.application.usecase.creartransaccion.CrearTransaccion;
import com.bancolombia.cuentas.application.usecase.creartransaccion.validator.CrearTransasccionRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public final class CrearTransaccionImpl implements CrearTransaccion {

    private final TransaccionEntityMapper transaccionEntityMapper;
    private final TransaccionRepository transaccionRepository;
    private final CrearTransasccionRulesValidator crearTransasccionRulesValidator;

    public CrearTransaccionImpl(final TransaccionEntityMapper transaccionEntityMapper,
                                final TransaccionRepository transaccionRepository,
                                final CrearTransasccionRulesValidator crearTransasccionRulesValidator) {
        this.transaccionEntityMapper = transaccionEntityMapper;
        this.transaccionRepository = transaccionRepository;
        this.crearTransasccionRulesValidator = crearTransasccionRulesValidator;
    }

    @Override
    public void execute(TransaccionDomain domain) {
        domain.setFecha(LocalDateTime.now());
        crearTransasccionRulesValidator.validate(domain);

        final var transaccionEntity = transaccionEntityMapper.toEntity(domain);
        transaccionRepository.save(transaccionEntity);

    }
}

