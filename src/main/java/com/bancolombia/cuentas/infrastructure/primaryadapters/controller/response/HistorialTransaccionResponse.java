package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.Response;

import java.util.ArrayList;

public final class HistorialTransaccionResponse extends Response<HistorialTransaccionDTO> {

    public HistorialTransaccionResponse() {
        setDatos(new ArrayList<>());
        setMensajes(new ArrayList<>());
    }
}
