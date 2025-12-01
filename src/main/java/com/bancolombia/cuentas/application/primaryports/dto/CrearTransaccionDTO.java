package com.bancolombia.cuentas.application.primaryports.dto;

import com.bancolombia.cuentas.crosscutting.helpers.TextHelper;
import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;

import java.math.BigDecimal;
import java.util.UUID;

public final class CrearTransaccionDTO {

    private UUID cuentaId;
    private TipoTransaccion tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;


    public CrearTransaccionDTO(final UUID cuentaId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                               final String descripcion) {
        setCuentaId(cuentaId);
        setTipoTransaccion(tipoTransaccion);
        setMonto(monto);
        setDescripcion(descripcion);
    }

    public CrearTransaccionDTO create (final UUID cuentaId, final TipoTransaccion tipoTransaccion, final BigDecimal monto,
                                       final String descripcion) {
        return new CrearTransaccionDTO(cuentaId, tipoTransaccion, monto, descripcion);
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

    public void setCuentaId(final UUID cuentaId) {
        this.cuentaId = UUIDHelper.getDefault(cuentaId, UUIDHelper.getDefault());
    }

    public void setTipoTransaccion(final TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public void setMonto(final BigDecimal monto) {
        this.monto = monto == null ? BigDecimal.ZERO : monto;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = TextHelper.applyTrim(descripcion);
    }

}
