package com.bancolombia.cuentas.application.usecase.historialtransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.entity.TransaccionEntity;
import com.bancolombia.cuentas.application.secondaryports.mapper.TransaccionEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.application.usecase.historialtransaccion.validator.HistorialTransaccionRulesValidator;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class HistorialTransaccionImplTest {

    private TransaccionRepository repo;
    private TransaccionEntityMapper mapper;
    private HistorialTransaccionRulesValidator validator;

    private HistorialTransaccionImpl useCase;

    @BeforeEach
    void setUp() {
        repo = mock(TransaccionRepository.class);
        mapper = mock(TransaccionEntityMapper.class);
        validator = mock(HistorialTransaccionRulesValidator.class);

        useCase = new HistorialTransaccionImpl(repo, mapper, validator);
    }

    @Test
    void execute_deberiaRetornarHistorialCuandoExiste() {
        UUID cuentaId = UUID.randomUUID();

        var entity = TransaccionEntity.create(
                UUID.randomUUID(),
                null,
                "Pago",
                BigDecimal.TEN,
                LocalDateTime.now(),
                null
        );

        var domain = mock(TransaccionDomain.class);

        when(repo.findByCuentaIdOrderByFechaDesc(cuentaId)).thenReturn(List.of(entity));
        when(mapper.toDomains(List.of(entity))).thenReturn(List.of(domain));

        var resultado = useCase.execute(cuentaId);

        assertThat(resultado).isNotEmpty();
        assertThat(resultado.size()).isEqualTo(1);

        verify(validator).validate(cuentaId);
        verify(repo).findByCuentaIdOrderByFechaDesc(cuentaId);
        verify(mapper).toDomains(List.of(entity));
    }

    @Test
    void execute_deberiaLanzarExcepcionCuandoReglaFalla() {
        UUID cuentaId = UUID.randomUUID();

        doThrow(new RuntimeException("Regla falló")).when(validator).validate(cuentaId);

        assertThatThrownBy(() -> useCase.execute(cuentaId))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Regla falló");

        verify(validator).validate(cuentaId);
        verifyNoInteractions(repo, mapper);
    }
}
