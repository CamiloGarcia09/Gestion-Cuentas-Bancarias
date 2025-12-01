package com.bancolombia.cuentas.domain.transaccion.exceptions.id;

public final class TransaccionIdDoesExistsException extends IllegalArgumentException {

    public TransaccionIdDoesExistsException(String message) {
        super(message);
    }
}
