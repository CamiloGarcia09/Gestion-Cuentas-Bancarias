package com.bancolombia.cuentas.application.primaryports.dto;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;

import java.math.BigDecimal;

public final class CrearCuentaDTO {

    private String numeroCuenta;
    private String nombreTitular;
    private BigDecimal saldoInicial;

    public CrearCuentaDTO(final String numeroCuenta, final String nombreTitular, final BigDecimal saldoInicial) {
        setNumeroCuenta(numeroCuenta);
        setNombreTitular(nombreTitular);
        setSaldoInicial(saldoInicial);
    }

    public static CrearCuentaDTO create (final String numeroCuenta, final String nombreTitular, final BigDecimal saldoInicial) {
        return new CrearCuentaDTO(numeroCuenta, nombreTitular, saldoInicial);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setNumeroCuenta(final String numeroCuenta) {
        this.numeroCuenta = TextHelper.applyTrim(numeroCuenta);
    }

    public void setNombreTitular(final String nombreTitular) {
        this.nombreTitular = TextHelper.applyTrim(nombreTitular);
    }

    public void setSaldoInicial(final BigDecimal saldoInical) {
        this.saldoInicial = saldoInical;
    }
}
