package com.bancolombia.cuentas.domain.transaccion.rules.monto.impl;

import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.ActualizarSaldoCuentaRule;
import org.springframework.stereotype.Service;

@Service
public final class ActualizarSaldoCuentaRuleImpl implements ActualizarSaldoCuentaRule {

    @Override
    public void validate(TransaccionDomain domain) {

        switch (domain.getTipoTransaccion()) {
            case DEPOSITO:
                domain.getCuenta().incrementarSaldo(domain.getMonto());
                break;

            case RETIRO:
                domain.getCuenta().decrementarSaldo(domain.getMonto());
                break;

            default:
                throw new IllegalArgumentException("Tipo de transacción no soportado");
        }
    }
}
