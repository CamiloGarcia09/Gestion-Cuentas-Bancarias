package com.bancolombia.cuentas.application.secondaryports.service;

import com.bancolombia.cuentas.domain.event.TransaccionCreadaEvent;

public interface TransaccionEvent {
    void manejarTransaccionCreada(TransaccionCreadaEvent event);
}
