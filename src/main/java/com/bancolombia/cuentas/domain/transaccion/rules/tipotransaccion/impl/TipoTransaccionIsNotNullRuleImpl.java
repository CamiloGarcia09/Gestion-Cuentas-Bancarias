package com.bancolombia.cuentas.domain.transaccion.rules.tipotransaccion.impl;

import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import com.bancolombia.cuentas.domain.transaccion.exceptions.tipotransaccion.TipoTransaccionInvalidaException;
import com.bancolombia.cuentas.domain.transaccion.rules.tipotransaccion.TipoTransaccionIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class TipoTransaccionIsNotNullRuleImpl implements TipoTransaccionIsNotNullRule {

    @Override
    public void validate(TipoTransaccion tipo) {
        if (tipo == null) {
            throw new TipoTransaccionInvalidaException("El tipo de transacción es obligatorio.");
        }

        if (tipo != TipoTransaccion.DEPOSITO && tipo != TipoTransaccion.RETIRO) {

            throw new TipoTransaccionInvalidaException(
                    "Tipo de transacción inválido. Solo se permite DEPOSITO o RETIRO."
            );
        }
    }
}
