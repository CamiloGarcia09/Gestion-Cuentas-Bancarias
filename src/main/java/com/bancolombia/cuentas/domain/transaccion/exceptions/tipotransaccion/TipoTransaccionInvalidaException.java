package com.bancolombia.cuentas.domain.transaccion.exceptions.tipotransaccion;

public final class TipoTransaccionInvalidaException extends IllegalArgumentException {

    public TipoTransaccionInvalidaException(String message) {
        super(message);
    }
}
