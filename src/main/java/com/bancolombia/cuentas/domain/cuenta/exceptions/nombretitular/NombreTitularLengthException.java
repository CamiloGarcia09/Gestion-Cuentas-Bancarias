package com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular;

public final class NombreTitularLengthException extends IllegalArgumentException {

    public NombreTitularLengthException(String message) {
        super(message);
    }
}
