package com.bancolombia.cuentas.application.primaryports.interactor.consultarsaldocuenta;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.InteractorWithReturn;

import java.util.UUID;

public interface ConsultarSaldoCuentaInteractor extends InteractorWithReturn <UUID, ConsultarSaldoCuentaDTO> {
}
