package com.bancolombia.cuentas.application.primaryports.interactor.historialtransaccion;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.InteractorWithReturn;

import java.util.List;
import java.util.UUID;

public interface HistorialTransaccionInteractor extends InteractorWithReturn <UUID, List<HistorialTransaccionDTO>> {
}
