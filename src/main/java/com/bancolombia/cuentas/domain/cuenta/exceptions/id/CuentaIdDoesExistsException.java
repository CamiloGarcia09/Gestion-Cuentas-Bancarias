package com.bancolombia.cuentas.domain.cuenta.exceptions.id;

public final class CuentaIdDoesExistsException extends IllegalArgumentException {

    public CuentaIdDoesExistsException (String message) {
        super(message);
    }
}
