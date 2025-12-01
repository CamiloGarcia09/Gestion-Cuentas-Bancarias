package com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta;

public final class NumeroCuentaAlreadyExistsException extends IllegalArgumentException {

    public NumeroCuentaAlreadyExistsException(String message) {
        super(message);
    }
}
