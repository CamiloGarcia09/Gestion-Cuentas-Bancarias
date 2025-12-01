package com.bancolombia.cuentas.domain.transaccion.rules.monto.impl;

import com.bancolombia.cuentas.crosscutting.helpers.NumericHelper;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import com.bancolombia.cuentas.domain.transaccion.exceptions.monto.SaldoInsuficienteException;
import com.bancolombia.cuentas.domain.transaccion.rules.monto.SaldoDisponibleRule;
import org.springframework.stereotype.Service;

@Service
public final class SaldoDisponibleRuleImpl implements SaldoDisponibleRule {

    @Override
    public void validate(TransaccionDomain domain) {

        if (domain.getTipoTransaccion() == TipoTransaccion.RETIRO &&
                NumericHelper.isLess(domain.getCuenta().getSaldo(), domain.getMonto())) {

            throw new SaldoInsuficienteException("La cuenta no tiene saldo suficiente. Saldo actua: " + domain.getCuenta().getSaldo());
        }
    }
}
