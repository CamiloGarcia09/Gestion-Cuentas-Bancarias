package com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta;

public final class NumeroCuentaEmptyException extends IllegalArgumentException {

    public NumeroCuentaEmptyException(String message) {
        super(message);
    }
}
