package com.bancolombia.cuentas.application.usecase.historialtransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.TransaccionEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.application.usecase.historialtransaccion.HistorialTransaccion;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class HistorialTransaccionImpl implements HistorialTransaccion {

    private final TransaccionRepository transaccionRepository;
    private final TransaccionEntityMapper transaccionEntityMapper;

    public HistorialTransaccionImpl(final TransaccionRepository transaccionRepository,
                                    final TransaccionEntityMapper transaccionEntityMapper) {
        this.transaccionRepository = transaccionRepository;
        this.transaccionEntityMapper = transaccionEntityMapper;
    }

    @Override
    public List<TransaccionDomain> execute(UUID data) {
        final var resultado = transaccionRepository.findByCuentaIdOrderByFechaDesc(data);
        return transaccionEntityMapper.toDomains(resultado);
    }
}
