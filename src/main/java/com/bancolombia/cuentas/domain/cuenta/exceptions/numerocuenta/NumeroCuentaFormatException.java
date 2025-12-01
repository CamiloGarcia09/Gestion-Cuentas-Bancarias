package com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta;

public final class NumeroCuentaFormatException extends IllegalArgumentException {

    public NumeroCuentaFormatException(String message) {
        super(message);
    }
}
