package com.bancolombia.cuentas.domain.transaccion;

import com.bancolombia.cuentas.domain.Domain;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class TransaccionDomain extends Domain {

    private TipoTransaccion tipoTransaccion;
    private String descripcion;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private CuentaDomain cuenta;

    public TransaccionDomain(final UUID id, final TipoTransaccion tipoTransaccion, final String descripcion,
                             final BigDecimal monto, final LocalDateTime fecha, CuentaDomain cuenta) {
        super(id);
        setTipoTransaccion(tipoTransaccion);
        setDescripcion(descripcion);
        setMonto(monto);
        setFecha(fecha);
        setCuenta(cuenta);
    }

    public static TransaccionDomain create (UUID id, TipoTransaccion tipoTransaccion, String descripcion,
                                            BigDecimal monto, LocalDateTime fecha, CuentaDomain cuenta) {
        return new TransaccionDomain(id, tipoTransaccion, descripcion, monto, fecha, cuenta);
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

    public CuentaDomain getCuenta() {
        return cuenta;
    }

    private void setTipoTransaccion(final TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    private void setMonto(final BigDecimal monto) {
        this.monto = monto;
    }

    private void setFecha(final LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCuenta(CuentaDomain cuenta) {
        this.cuenta = cuenta;
    }
}
