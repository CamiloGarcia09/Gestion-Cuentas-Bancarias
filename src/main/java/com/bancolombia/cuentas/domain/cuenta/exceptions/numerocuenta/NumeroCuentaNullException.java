package com.bancolombia.cuentas.domain.cuenta.exceptions.numerocuenta;

public final class NumeroCuentaNullException extends IllegalArgumentException {

    public NumeroCuentaNullException(String message) {
        super(message);
    }
}
