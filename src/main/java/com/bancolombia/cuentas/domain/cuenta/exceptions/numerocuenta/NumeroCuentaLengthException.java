package com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta;

public final class NumeroCuentaLengthException extends IllegalArgumentException {

    public NumeroCuentaLengthException(String message) {
        super(message);
    }
}
