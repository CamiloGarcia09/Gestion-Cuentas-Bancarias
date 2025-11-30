package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.Response;

import java.util.ArrayList;

public final class ConsultarSaldoCuentaResponse extends Response <ConsultarSaldoCuentaDTO>  {

    public ConsultarSaldoCuentaResponse(){
            setMensajes(new ArrayList<>());
            setDatos(new ArrayList<>());
    }
}
