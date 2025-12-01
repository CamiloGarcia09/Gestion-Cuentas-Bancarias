package com.bancolombia.cuentas.application.primaryports.interactor.creartransaccion.impl;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.mapper.CrearTransaccionDTOMapper;
import com.bancolombia.cuentas.application.usecase.creartransaccion.CrearTransaccion;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;

class CrearTransaccionInteractorImplTest {

    private CrearTransaccion crearTransaccion;
    private CrearTransaccionDTOMapper mapper;
    private CrearTransaccionInteractorImpl interactor;

    @BeforeEach
    void setUp() {
        crearTransaccion = mock(CrearTransaccion.class);
        mapper = mock(CrearTransaccionDTOMapper.class);
        interactor = new CrearTransaccionInteractorImpl(crearTransaccion, mapper);
    }

    @Test
    void execute_deberiaMapearYEnviarAlUseCase() {

        UUID cuentaId = UUID.randomUUID();
        var dto = new CrearTransaccionDTO(
                cuentaId,
                TipoTransaccion.DEPOSITO,
                BigDecimal.TEN,
                "Recarga"
        );

        var domain = TransaccionDomain.create(
                UUID.randomUUID(),
                TipoTransaccion.DEPOSITO,
                "Recarga",
                BigDecimal.TEN,
                null,
                CuentaDomain.create(cuentaId, null, null, null)
        );

        when(mapper.toDomain(dto)).thenReturn(domain);

        interactor.execute(dto);

        verify(mapper, times(1)).toDomain(dto);
        verify(crearTransaccion, times(1)).execute(domain);
        verifyNoMoreInteractions(mapper, crearTransaccion);
    }
}