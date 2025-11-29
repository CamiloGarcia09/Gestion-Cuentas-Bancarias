package com.bancolombia.cuentas.application.primaryports.interactor.crearcuenta.impl;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.crearcuenta.CrearCuentaInteractor;
import com.bancolombia.cuentas.application.primaryports.mapper.CuentaDTOMapper;
import com.bancolombia.cuentas.application.usecase.crearcuenta.CrearCuenta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearCuentaInteractorImpl implements CrearCuentaInteractor {

    private final CrearCuenta crearCuenta;
    private final CuentaDTOMapper cuentaDTOMapper;

    public CrearCuentaInteractorImpl(final CrearCuenta crearCuenta, final CuentaDTOMapper cuentaDTOMapper) {
        this.crearCuenta = crearCuenta;
        this.cuentaDTOMapper = cuentaDTOMapper;
    }

    @Override
    public void execute(CrearCuentaDTO data) {

        final var cuentaDomain = cuentaDTOMapper.toDomain(data);
        crearCuenta.execute(cuentaDomain);
    }
}
