package com.bancolombia.cuentas.application.primaryports.dto;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class HistorialTransaccionDTO {

    private UUID transaccionId;
    private TipoTransaccion tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fecha;

    public HistorialTransaccionDTO(final UUID transaccionId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                                   final String descripcion, final LocalDateTime fecha) {
        setTransaccionId(transaccionId);
        setTipoTransaccion(tipoTransaccion);
        setMonto(monto);
        setDescripcion(descripcion);
        setFecha(fecha);
    }

    public HistorialTransaccionDTO create (final UUID transaccionId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                                           final String descripcion, final LocalDateTime fecha) {
        return new HistorialTransaccionDTO(transaccionId, tipoTransaccion, monto, descripcion, fecha);
    }

    public UUID getTransaccionId() {
        return transaccionId;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setTransaccionId(final UUID transaccionId) {
        this.transaccionId = UUIDHelper.getDefault(transaccionId, UUIDHelper.getDefault());;
    }

    public void setTipoTransaccion(final TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion == null ? TipoTransaccion.defaultValue() : tipoTransaccion;
    }

    public void setMonto(final BigDecimal monto) {
        this.monto = monto == null ? BigDecimal.ZERO : monto;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = TextHelper.applyTrim(descripcion);
    }

    public void setFecha(final LocalDateTime fecha) {
        this.fecha = fecha == null ? LocalDateTime.now() : fecha;
    }
}
