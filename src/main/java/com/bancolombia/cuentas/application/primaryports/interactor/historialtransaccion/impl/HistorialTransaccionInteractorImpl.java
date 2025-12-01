package com.bancolombia.cuentas.application.primaryports.interactor.historialtransaccion.impl;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.historialtransaccion.HistorialTransaccionInteractor;
import com.bancolombia.cuentas.application.primaryports.mapper.HistorialTransaccionDTOMapper;
import com.bancolombia.cuentas.application.usecase.historialtransaccion.HistorialTransaccion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HistorialTransaccionInteractorImpl implements HistorialTransaccionInteractor {

    private final HistorialTransaccion historialTransaccion;
    private final HistorialTransaccionDTOMapper historialTransaccionDTOMapper;

    public HistorialTransaccionInteractorImpl(final HistorialTransaccion historialTransaccion,
                                              final HistorialTransaccionDTOMapper historialTransaccionDTOMapper) {
        this.historialTransaccion = historialTransaccion;
        this.historialTransaccionDTOMapper = historialTransaccionDTOMapper;
    }

    @Override
    public List<HistorialTransaccionDTO> execute(UUID data) {

        final var resultados = historialTransaccion.execute(data);
        return historialTransaccionDTOMapper.toDTOList(resultados);
    }
}
