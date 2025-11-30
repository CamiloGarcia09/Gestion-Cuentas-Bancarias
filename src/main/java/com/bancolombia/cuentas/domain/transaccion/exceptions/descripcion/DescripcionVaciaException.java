package com.bancolombia.cuentas.domain.transaccion.exceptions.descripcion;

public final class DescripcionVaciaException extends IllegalArgumentException {

    public DescripcionVaciaException(String message) {
        super(message);
    }
}
