package com.bancolombia.cuentas.domain.cuenta.exceptions.nombretitular;

public final class NombreTitularEmptyException extends IllegalArgumentException {

    public NombreTitularEmptyException(String message) {
        super(message);
    }
}
