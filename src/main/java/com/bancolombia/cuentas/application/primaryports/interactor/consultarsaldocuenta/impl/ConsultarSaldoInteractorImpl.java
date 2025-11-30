package com.bancolombia.cuentas.application.primaryports.interactor.consultarsaldocuenta.impl;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.consultarsaldocuenta.ConsultarSaldoCuentaInteractor;
import com.bancolombia.cuentas.application.primaryports.mapper.ConsultarSaldoCuentaDTOMapper;
import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.ConsultarSaldoCuenta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
public class ConsultarSaldoInteractorImpl implements ConsultarSaldoCuentaInteractor {

    private final ConsultarSaldoCuenta consultarSaldo;
    private final ConsultarSaldoCuentaDTOMapper consultarSaldoCuentaDTOMapper;

    public ConsultarSaldoInteractorImpl(final ConsultarSaldoCuenta consultarSaldo, final ConsultarSaldoCuentaDTOMapper consultarSaldoCuentaDTOMapper) {
        this.consultarSaldo = consultarSaldo;
        this.consultarSaldoCuentaDTOMapper = consultarSaldoCuentaDTOMapper;
    }


    @Override
    public ConsultarSaldoCuentaDTO execute(UUID data) {

        final var resultado = consultarSaldo.execute(data);
        return consultarSaldoCuentaDTOMapper.toDTO(resultado);
    }
}
