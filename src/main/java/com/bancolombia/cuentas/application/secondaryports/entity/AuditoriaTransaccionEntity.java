package com.bancolombia.cuentas.application.secondaryports.entity;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auditoria_transaccion")
public final class AuditoriaTransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "transaccion_id", nullable = false)
    private UUID transaccionId;

    @Column(name = "cuenta_id", nullable = false)
    private UUID cuentaId;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "saldo_antes", nullable = false)
    private BigDecimal saldoAntes;

    @Column(name = "saldo_despues", nullable = false)
    private BigDecimal saldoDespues;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    public AuditoriaTransaccionEntity() {
        setId(UUIDHelper.getDefault());
        setTransaccionId(UUIDHelper.getDefault());
        setCuentaId(UUIDHelper.getDefault());
        setTipo(TextHelper.EMPTY);
        setMonto(BigDecimal.ZERO);
        setSaldoAntes(BigDecimal.ZERO);
        setSaldoDespues(BigDecimal.ZERO);
        setFecha(LocalDateTime.now());
        setDescripcion(TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public UUID getTransaccionId() {
        return transaccionId;
    }

    public UUID getCuentaId() {
        return cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public BigDecimal getSaldoAntes() {
        return saldoAntes;
    }

    public BigDecimal getSaldoDespues() {
        return saldoDespues;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTransaccionId(final UUID transaccionId) {
        this.transaccionId = transaccionId;
    }

    public void setCuentaId(final UUID cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public void setMonto(final BigDecimal monto) {
        this.monto = monto;
    }

    public void setSaldoAntes(final BigDecimal saldoAntes) {
        this.saldoAntes = saldoAntes;
    }

    public void setSaldoDespues(final BigDecimal saldoDespues) {
        this.saldoDespues = saldoDespues;
    }

    public void setFecha(final LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
