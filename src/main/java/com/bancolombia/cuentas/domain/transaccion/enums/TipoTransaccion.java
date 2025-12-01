package com.bancolombia.cuentas.domain.transaccion.enums;

public enum TipoTransaccion {

    DEPOSITO, RETIRO;

    public static TipoTransaccion defaultValue() {
        return DEPOSITO;
    }
}
