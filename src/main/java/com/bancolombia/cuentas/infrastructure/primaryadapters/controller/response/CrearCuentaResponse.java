package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.Response;

import java.util.ArrayList;

public final class CrearCuentaResponse extends Response  <CrearCuentaDTO>{

    public CrearCuentaResponse(){
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
