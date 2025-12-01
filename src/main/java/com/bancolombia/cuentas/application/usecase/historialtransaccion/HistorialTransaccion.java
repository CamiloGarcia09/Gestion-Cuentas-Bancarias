package com.bancolombia.cuentas.application.usecase.historialtransaccion;

import com.bancolombia.cuentas.application.primaryports.interactor.InteractorWithReturn;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;

import java.util.List;
import java.util.UUID;

public interface HistorialTransaccion extends InteractorWithReturn<UUID, List<TransaccionDomain>> {
}
