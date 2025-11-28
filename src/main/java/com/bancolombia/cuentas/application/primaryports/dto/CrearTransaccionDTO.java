package com.bancolombia.cuentas.application.primaryports.dto;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class CrearTransaccionDTO {

    private UUID cuentaId;
    private TipoTransaccion tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;
    private LocalDateTime fecha;

    public CrearTransaccionDTO(final UUID cuentaId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                               final String descripcion, final LocalDateTime fecha) {
        setCuentaId(cuentaId);
        setTipoTransaccion(tipoTransaccion);
        setMonto(monto);
        setDescripcion(descripcion);
        setFecha(fecha);
    }

    public CrearTransaccionDTO create (final UUID cuentaId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                               final String descripcion, final LocalDateTime fecha) {
        return new CrearTransaccionDTO(cuentaId, tipoTransaccion, monto, descripcion, fecha);
    }

    public UUID getCuentaId() {
        return cuentaId;
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

    public void setCuentaId(final UUID cuentaId) {
        this.cuentaId = UUIDHelper.getDefault(cuentaId, UUIDHelper.getDefault());
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
