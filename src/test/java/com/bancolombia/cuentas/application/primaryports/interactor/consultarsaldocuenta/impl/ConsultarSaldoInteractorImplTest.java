package com.bancolombia.cuentas.application.primaryports.interactor.consultarsaldocuenta.impl;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.mapper.ConsultarSaldoCuentaDTOMapper;
import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.ConsultarSaldoCuenta;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ConsultarSaldoInteractorImplTest {

    private ConsultarSaldoCuenta useCase;
    private ConsultarSaldoCuentaDTOMapper mapper;

    private ConsultarSaldoInteractorImpl interactor;

    @BeforeEach
    void setUp() {
        useCase = mock(ConsultarSaldoCuenta.class);
        mapper = mock(ConsultarSaldoCuentaDTOMapper.class);

        interactor = new ConsultarSaldoInteractorImpl(useCase, mapper);
    }

    @Test
    void execute_deberiaRetornarDTO() {
        UUID id = UUID.randomUUID();

        CuentaDomain domain = CuentaDomain.create(
                id,
                "123456",
                "Juan Pérez",
                BigDecimal.TEN
        );

        ConsultarSaldoCuentaDTO dto = new ConsultarSaldoCuentaDTO(
                "Juan Pérez",
                BigDecimal.TEN

        );

        when(useCase.execute(id)).thenReturn(domain);
        when(mapper.toDTO(domain)).thenReturn(dto);

        ConsultarSaldoCuentaDTO resultado = interactor.execute(id);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombreTitular().equals("Juan Pérez"));

        verify(useCase).execute(id);
        verify(mapper).toDTO(domain);
    }
}