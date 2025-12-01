package com.bancolombia.cuentas.application.primaryports.interactor.historialtransaccion.impl;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.mapper.HistorialTransaccionDTOMapper;
import com.bancolombia.cuentas.application.usecase.historialtransaccion.HistorialTransaccion;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class HistorialTransaccionInteractorImplTest {

    private HistorialTransaccion useCase;
    private HistorialTransaccionDTOMapper mapper;

    private HistorialTransaccionInteractorImpl interactor;

    @BeforeEach
    void setUp() {
        useCase = mock(HistorialTransaccion.class);
        mapper = mock(HistorialTransaccionDTOMapper.class);

        interactor = new HistorialTransaccionInteractorImpl(useCase, mapper);
    }

    @Test
    void execute_deberiaRetornarDTOList() {
        UUID cuentaId = UUID.randomUUID();

        var domain = mock(TransaccionDomain.class);
        var dto = mock(HistorialTransaccionDTO.class);

        when(useCase.execute(cuentaId)).thenReturn(List.of(domain));
        when(mapper.toDTOList(List.of(domain))).thenReturn(List.of(dto));

        var resultado = interactor.execute(cuentaId);

        assertThat(resultado).isNotEmpty();
        assertThat(resultado.size()).isEqualTo(1);

        verify(useCase).execute(cuentaId);
        verify(mapper).toDTOList(List.of(domain));
    }
}