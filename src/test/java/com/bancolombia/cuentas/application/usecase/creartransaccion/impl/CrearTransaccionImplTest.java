package com.bancolombia.cuentas.application.usecase.creartransaccion.impl;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.mapper.TransaccionEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.secondaryports.repository.TransaccionRepository;
import com.bancolombia.cuentas.application.usecase.creartransaccion.impl.impl.CrearTransaccionImpl;
import com.bancolombia.cuentas.application.usecase.creartransaccion.impl.validator.CrearTransasccionRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.cuenta.exceptions.id.CuentaIdDoesExistsException;
import com.bancolombia.cuentas.domain.event.TransaccionCreadaEvent;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

class CrearTransaccionImplTest {

    private TransaccionEntityMapper transaccionEntityMapper;
    private TransaccionRepository transaccionRepository;
    private CuentaEntityMapper cuentaEntityMapper;
    private CuentaRepository cuentaRepository;
    private CrearTransasccionRulesValidator rulesValidator;
    private ApplicationEventPublisher eventPublisher;

    private CrearTransaccionImpl useCase;

    @BeforeEach
    void setUp() {
        transaccionEntityMapper = mock(TransaccionEntityMapper.class);
        transaccionRepository = mock(TransaccionRepository.class);
        cuentaEntityMapper = mock(CuentaEntityMapper.class);
        cuentaRepository = mock(CuentaRepository.class);
        rulesValidator = mock(CrearTransasccionRulesValidator.class);
        eventPublisher = mock(ApplicationEventPublisher.class);

        useCase = new CrearTransaccionImpl(
                transaccionEntityMapper,
                transaccionRepository,
                cuentaEntityMapper,
                cuentaRepository,
                rulesValidator,
                eventPublisher
        );
    }

    @Test
    void execute_deberiaRealizarTodaLaLogicaCorrectamente() {

        UUID cuentaId = UUID.randomUUID();
        UUID transaccionId = UUID.randomUUID();

        var cuentaDomainInicial = CuentaDomain.create(cuentaId, "123", "Juan", BigDecimal.valueOf(100));
        var transaccionDomain = TransaccionDomain.create(
                transaccionId,
                TipoTransaccion.DEPOSITO,
                "Pago",
                BigDecimal.valueOf(50),
                LocalDateTime.now(),
                cuentaDomainInicial
        );

        var cuentaEntityBD = CuentaEntity.create(
                cuentaId,
                "123",
                "Juan",
                BigDecimal.valueOf(100)
        );

        when(cuentaRepository.findById(cuentaId)).thenReturn(Optional.of(cuentaEntityBD));

        var cuentaDomainBD = CuentaDomain.create(
                cuentaId,
                "123",
                "Juan",
                BigDecimal.valueOf(100)
        );
        when(cuentaEntityMapper.toDomain(cuentaEntityBD)).thenReturn(cuentaDomainBD);

        var transaccionEntity = mock(com.bancolombia.cuentas.application.secondaryports.entity.TransaccionEntity.class);
        when(transaccionEntityMapper.toEntity(transaccionDomain)).thenReturn(transaccionEntity);

        var cuentaActualizadaEntity = mock(CuentaEntity.class);
        when(cuentaEntityMapper.toEntity(cuentaDomainBD)).thenReturn(cuentaActualizadaEntity);

        useCase.execute(transaccionDomain);

        verify(cuentaRepository).findById(cuentaId);
        verify(cuentaEntityMapper).toDomain(cuentaEntityBD);
        verify(rulesValidator).validate(transaccionDomain);
        verify(transaccionEntityMapper).toEntity(transaccionDomain);
        verify(transaccionRepository).save(transaccionEntity);
        verify(cuentaEntityMapper).toEntity(cuentaDomainBD);
        verify(cuentaRepository).save(cuentaActualizadaEntity);
        verify(eventPublisher).publishEvent(any(TransaccionCreadaEvent.class));
    }


    @Test
    void execute_deberiaLanzarExcepcionCuandoCuentaNoExiste() {

        UUID cuentaId = UUID.randomUUID();
        var cuentaDomain = CuentaDomain.create(cuentaId, "123", "Juan", BigDecimal.TEN);

        var transaccionDomain = TransaccionDomain.create(
                UUID.randomUUID(),
                TipoTransaccion.DEPOSITO,
                "Pago",
                BigDecimal.valueOf(50),
                LocalDateTime.now(),
                cuentaDomain
        );

        when(cuentaRepository.findById(cuentaId)).thenReturn(Optional.empty());

        try {
            useCase.execute(transaccionDomain);
        } catch (CuentaIdDoesExistsException ex) {
            assert ex.getMessage().equals("Cuenta no encontrada");
        }

        verify(cuentaRepository).findById(cuentaId);
        verifyNoMoreInteractions(cuentaRepository);
    }
}