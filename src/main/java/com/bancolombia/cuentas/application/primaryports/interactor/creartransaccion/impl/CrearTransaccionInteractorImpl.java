package com.bancolombia.cuentas.application.primaryports.interactor.creartransaccion.impl;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.creartransaccion.CrearTransaccionInteractor;
import com.bancolombia.cuentas.application.primaryports.mapper.CrearTransaccionDTOMapper;
import com.bancolombia.cuentas.application.usecase.creartransaccion.CrearTransaccion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTransaccionInteractorImpl implements CrearTransaccionInteractor {

    private final CrearTransaccion crearTransaccion;
    private final CrearTransaccionDTOMapper transaccionDTOMapper;

    public CrearTransaccionInteractorImpl(final CrearTransaccion crearTransaccion,
                                          final CrearTransaccionDTOMapper transaccionDTOMapper) {
        this.crearTransaccion = crearTransaccion;
        this.transaccionDTOMapper = transaccionDTOMapper;
    }

    @Override
    public void execute(CrearTransaccionDTO data) {

        final var transaccionDomain = transaccionDTOMapper.toDomain(data);

        crearTransaccion.execute(transaccionDomain);
    }
}
