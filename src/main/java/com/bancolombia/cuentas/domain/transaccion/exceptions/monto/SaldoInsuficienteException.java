package com.bancolombia.cuentas.domain.transaccion.exceptions.monto;

public final class SaldoInsuficienteException extends IllegalArgumentException {

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
