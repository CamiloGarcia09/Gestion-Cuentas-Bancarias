package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta;

import com.bancolombia.cuentas.application.usecase.UseCaseWhitReturn;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;

import java.util.UUID;


public interface ConsultarSaldoCuenta extends UseCaseWhitReturn <UUID, CuentaDomain> {
}
