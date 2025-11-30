package com.bancolombia.cuentas.infrastructure.secondaryadapters.events;

import com.bancolombia.cuentas.application.secondaryports.entity.AuditoriaTransaccionEntity;
import com.bancolombia.cuentas.application.secondaryports.repository.AuditoriaTransaccionRepository;
import com.bancolombia.cuentas.application.secondaryports.service.TransaccionEvent;
import com.bancolombia.cuentas.domain.event.TransaccionCreadaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public final class TransaccionEventService implements TransaccionEvent {

    private final AuditoriaTransaccionRepository auditoriaRepository;

    public TransaccionEventService(final AuditoriaTransaccionRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    @Override
    @EventListener
    public void manejarTransaccionCreada(final TransaccionCreadaEvent event) {

        var entity = new AuditoriaTransaccionEntity();

        entity.setTransaccionId(event.getTransaccionId());
        entity.setCuentaId(event.getCuentaId());
        entity.setTipo(event.getTipoTransaccion().name());
        entity.setMonto(event.getMonto());
        entity.setSaldoAntes(event.getSaldoAntes());
        entity.setSaldoDespues(event.getSaldoDespues());
        entity.setFecha(event.getFecha());

        var descripcion = String.format(
                "Transacción %s por %s en la cuenta %s. Descripción: %s",
                event.getTipoTransaccion().name(),
                event.getMonto(),
                event.getNumeroCuenta(),
                event.getDescripcion()
        );

        entity.setDescripcion(descripcion);

        auditoriaRepository.save(entity);
    }
}