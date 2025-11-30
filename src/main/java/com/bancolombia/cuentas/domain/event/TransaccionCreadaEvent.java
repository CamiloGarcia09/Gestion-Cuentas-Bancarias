package com.bancolombia.cuentas.domain.event;

import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class TransaccionCreadaEvent {

    private final UUID transaccionId;
    private final UUID cuentaId;
    private final TipoTransaccion tipoTransaccion;
    private final BigDecimal monto;
    private final BigDecimal saldoAntes;
    private final BigDecimal saldoDespues;
    private final LocalDateTime fecha;
    private final String numeroCuenta;
    private final String descripcion;

    public TransaccionCreadaEvent(final UUID transaccionId, final UUID cuentaId, final TipoTransaccion tipoTransaccion,
                                  final BigDecimal monto, final BigDecimal saldoAntes, final BigDecimal saldoDespues,
                                  final LocalDateTime fecha, final String numeroCuenta, final String descripcion) {
        this.transaccionId = transaccionId;
        this.cuentaId = cuentaId;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.saldoAntes = saldoAntes;
        this.saldoDespues = saldoDespues;
        this.fecha = fecha;
        this.numeroCuenta = numeroCuenta;
        this.descripcion = descripcion;
    }

    public UUID getTransaccionId() {
        return transaccionId;
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

    public BigDecimal getSaldoAntes() {
        return saldoAntes;
    }

    public BigDecimal getSaldoDespues() {
        return saldoDespues;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
