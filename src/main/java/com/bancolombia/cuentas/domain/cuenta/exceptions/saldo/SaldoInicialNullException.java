package com.bancolombia.cuentas.domain.cuenta.exceptions.saldo;

public final class SaldoInicialNullException extends IllegalArgumentException {

    public SaldoInicialNullException(String message) {
        super(message);
    }
}
