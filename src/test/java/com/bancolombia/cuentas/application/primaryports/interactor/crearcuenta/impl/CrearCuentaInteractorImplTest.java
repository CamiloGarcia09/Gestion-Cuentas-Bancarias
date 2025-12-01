package com.bancolombia.cuentas.application.primaryports.interactor.crearcuenta.impl;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.mapper.CrearCuentaDTOMapper;
import com.bancolombia.cuentas.application.usecase.crearcuenta.CrearCuenta;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class CrearCuentaInteractorImplTest {

    private CrearCuenta crearCuenta;
    private CrearCuentaDTOMapper mapper;
    private CrearCuentaInteractorImpl interactor;

    @BeforeEach
    void setUp() {
        crearCuenta = mock(CrearCuenta.class);
        mapper = mock(CrearCuentaDTOMapper.class);
        interactor = new CrearCuentaInteractorImpl(crearCuenta, mapper);
    }

    @Test
    void execute_deberiaMapearYEnviarAlUseCase() {

        var dto = new CrearCuentaDTO("123", "Juan", BigDecimal.TEN);
        var domain = CuentaDomain.create(null, "123", "Juan", BigDecimal.TEN);

        when(mapper.toDomain(dto)).thenReturn(domain);

        interactor.execute(dto);

        verify(mapper, times(1)).toDomain(dto);
        verify(crearCuenta, times(1)).execute(domain);
        verifyNoMoreInteractions(mapper, crearCuenta);
    }
}
