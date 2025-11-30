package com.bancolombia.cuentas.domain.transaccion.exceptions;

public final class TransaccionIdDoesExistsException extends IllegalArgumentException {

    public TransaccionIdDoesExistsException(String message) {
        super(message);
    }
}
