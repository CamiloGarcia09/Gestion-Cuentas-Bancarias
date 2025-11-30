package com.bancolombia.cuentas.domain.transaccion.exceptions.monto;

public final class MontoInvalidoException extends IllegalArgumentException {

    public MontoInvalidoException(String message) {
        super(message);
    }
}
