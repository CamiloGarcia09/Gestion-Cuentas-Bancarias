package com.bancolombia.cuentas.domain.cuenta.exceptions.id;

public final class CuentaIdDoesNotExistsException extends IllegalArgumentException {

    public CuentaIdDoesNotExistsException(String message) {
        super(message);
    }
}
