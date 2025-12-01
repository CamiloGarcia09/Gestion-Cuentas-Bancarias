package com.bancolombia.cuentas.domain.cuenta.exceptions.saldo;

public final class SaldoInicialNegativeException extends IllegalArgumentException {

    public SaldoInicialNegativeException(String message) {
        super(message);
    }
}
