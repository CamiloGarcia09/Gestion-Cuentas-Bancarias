package com.bancolombia.cuentas.application.secondaryports.entity;

import com.bancolombia.cuentas.crosscutting.helpers.ObjectHelper;
import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Transaccion")
public final class TransaccionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion")
    private TipoTransaccion tipoTransaccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private CuentaEntity cuenta;

    public TransaccionEntity() {
        setId(UUIDHelper.getDefault());
        setTipoTransaccion(TipoTransaccion.defaultValue());
        setDescripcion(TextHelper.EMPTY);
        setMonto(BigDecimal.ZERO);
        setFecha(LocalDateTime.now());
        setCuenta(CuentaEntity.create());
    }

    public TransaccionEntity(final UUID id, final TipoTransaccion tipoTransaccion, final String descripcion,
                             final BigDecimal monto, final LocalDateTime fecha, final CuentaEntity cuenta) {

        setId(id);
        setTipoTransaccion(tipoTransaccion);
        setDescripcion(descripcion);
        setMonto(monto);
        setFecha(fecha);
        setCuenta(cuenta);
    }

    public static TransaccionEntity create() {
        return new TransaccionEntity();
    }

    public static TransaccionEntity create(final UUID id) {
        return new TransaccionEntity(id, null, TextHelper.EMPTY, BigDecimal.ZERO, LocalDateTime.now(), CuentaEntity.create());
    }

    public static TransaccionEntity create(final UUID id, final TipoTransaccion tipoTransaccion, final String descripcion,
                                           final BigDecimal monto, final LocalDateTime fecha, final CuentaEntity cuenta) {

        return new TransaccionEntity(id, tipoTransaccion, descripcion, monto, fecha, cuenta);
    }


    public UUID getId() {
        return id;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public CuentaEntity getCuenta() {
        return cuenta;
    }

    public TransaccionEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public TransaccionEntity setTipoTransaccion(final TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion =tipoTransaccion == null ? TipoTransaccion.defaultValue() : tipoTransaccion;
        return this;
    }

    public TransaccionEntity setDescripcion(final String descripcion) {
        this.descripcion = TextHelper.applyTrim(descripcion);
        return this;
    }

    public TransaccionEntity setMonto(final BigDecimal monto) {
        this.monto = monto == null ? BigDecimal.ZERO : monto;
        return this;
    }

    public TransaccionEntity setFecha(final LocalDateTime fecha) {
        this.fecha = fecha == null ? LocalDateTime.now() : fecha;
        return this;
    }

    public TransaccionEntity setCuenta(final CuentaEntity cuenta) {
        this.cuenta = ObjectHelper.getDefault(cuenta, CuentaEntity.create());
        return this;
    }
}