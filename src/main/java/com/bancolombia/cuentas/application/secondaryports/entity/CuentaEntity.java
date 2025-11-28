package com.bancolombia.cuentas.application.secondaryports.entity;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Cuenta")
public final class CuentaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "nombre_titular")
    private String nombreTitular;

    @Column(name = "saldo")
    private BigDecimal saldo;

    public CuentaEntity() {
        setId(UUIDHelper.getDefault());
        setNumeroCuenta(TextHelper.EMPTY);
        setNombreTitular(TextHelper.EMPTY);
        setSaldo(BigDecimal.ZERO);
    }

    public CuentaEntity(final UUID id, final String numeroCuenta, final String nombreTitular,
                        final BigDecimal saldo) {

        setId(id);
        setNumeroCuenta(numeroCuenta);
        setNombreTitular(nombreTitular);
        setSaldo(saldo);
    }

    public static CuentaEntity create() {
        return new CuentaEntity();
    }

    public static CuentaEntity create(final UUID id) {
        return new CuentaEntity(id, TextHelper.EMPTY, TextHelper.EMPTY, BigDecimal.ZERO);
    }

    public static CuentaEntity create(final UUID id, final String numeroCuenta, final String nombreTitular,
                                      final BigDecimal saldo) {
        return new CuentaEntity(id, numeroCuenta, nombreTitular, saldo);
    }

    public UUID getId() {
        return id;
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

    public CuentaEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public CuentaEntity setNumeroCuenta(final String numeroCuenta) {
        this.numeroCuenta = TextHelper.applyTrim(numeroCuenta);
        return this;
    }

    public CuentaEntity setNombreTitular(final String nombreTitular) {
        this.nombreTitular = TextHelper.applyTrim(nombreTitular);
        return this;
    }

    public CuentaEntity setSaldo(final BigDecimal saldo) {
        this.saldo = saldo == null ? BigDecimal.ZERO : saldo;
        return this;
    }

}
