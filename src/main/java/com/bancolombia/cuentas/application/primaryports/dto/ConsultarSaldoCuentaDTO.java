package com.bancolombia.cuentas.application.primaryports.dto;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;

import java.math.BigDecimal;

public final class ConsultarSaldoCuentaDTO {

    private String nombreTitular;
    private BigDecimal saldo;

    public ConsultarSaldoCuentaDTO(final String nombreTitular, final BigDecimal saldo) {
        setNombreTitular(nombreTitular);
        setSaldo(saldo);
    }

    public static ConsultarSaldoCuentaDTO create (final String nombreTitular, final BigDecimal saldo) {
        return new ConsultarSaldoCuentaDTO(nombreTitular, saldo);
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setNombreTitular(final String nombreTitular) {
        this.nombreTitular = TextHelper.applyTrim(nombreTitular);
    }

    public void setSaldo(final BigDecimal saldo) {
        this.saldo = saldo == null ? BigDecimal.ZERO : saldo;
    }

}
