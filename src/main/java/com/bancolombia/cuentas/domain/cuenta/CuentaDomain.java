package com.bancolombia.cuentas.domain.cuenta;

import com.bancolombia.cuentas.domain.Domain;
import java.math.BigDecimal;
import java.util.UUID;

public final class CuentaDomain extends Domain {

    private String numeroCuenta;
    private String nombreTitular;
    private BigDecimal saldo;

    public CuentaDomain(final UUID id, final String numeroCuenta, final String nombreTitular, final BigDecimal saldo) {
        super(id);
        setNumeroCuenta(numeroCuenta);
        setNombreTitular(nombreTitular);
        setSaldo(saldo);
    }

    public static CuentaDomain create(UUID id, String numeroCuenta, String nombreTitular, BigDecimal saldo){
        return new CuentaDomain(id, numeroCuenta, nombreTitular, saldo);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    private void setNumeroCuenta(final String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    private void setNombreTitular(final String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    private void setSaldo(final BigDecimal saldo) {
        this.saldo = saldo;
    }

}
