package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.validator.ConsultarSaldoCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsultarSaldoCuentaImplTest {

    private CuentaRepository cuentaRepository;
    private CuentaEntityMapper cuentaEntityMapper;
    private ConsultarSaldoCuentaRulesValidator rulesValidator;

    private ConsultarSaldoCuentaImpl useCase;

    @BeforeEach
    void setUp() {
        cuentaRepository = mock(CuentaRepository.class);
        cuentaEntityMapper = mock(CuentaEntityMapper.class);
        rulesValidator = mock(ConsultarSaldoCuentaRulesValidator.class);

        useCase = new ConsultarSaldoCuentaImpl(cuentaRepository, cuentaEntityMapper, rulesValidator);
    }

    @Test
    void execute_deberiaRetornarCuentaCuandoExiste() {
        UUID id = UUID.randomUUID();
        CuentaEntity entity = CuentaEntity.create(id, "123", "Juan", BigDecimal.TEN);
        CuentaDomain domain = CuentaDomain.create(id, "123", "Juan", BigDecimal.TEN);

        when(cuentaRepository.findById(id)).thenReturn(Optional.of(entity));
        when(cuentaEntityMapper.toDomain(entity)).thenReturn(domain);

        CuentaDomain resultado = useCase.execute(id);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(id);

        verify(rulesValidator).validate(id);
        verify(cuentaRepository).findById(id);
        verify(cuentaEntityMapper).toDomain(entity);
    }

    @Test
    void execute_deberiaLanzarExcepcionCuandoReglaFalla() {
        UUID id = UUID.randomUUID();

        doThrow(new RuntimeException("Error regla"))
                .when(rulesValidator).validate(id);

        assertThatThrownBy(() -> useCase.execute(id))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Error regla");

        verify(rulesValidator).validate(id);
        verifyNoMoreInteractions(cuentaRepository, cuentaEntityMapper);
    }

    @Test
    void execute_deberiaLanzarExcepcionCuandoCuentaNoExiste() {
        UUID id = UUID.randomUUID();

        when(cuentaRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> useCase.execute(id))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Cuenta no entontrada");

        verify(rulesValidator).validate(id);
        verify(cuentaRepository).findById(id);
        verifyNoInteractions(cuentaEntityMapper);
    }
}