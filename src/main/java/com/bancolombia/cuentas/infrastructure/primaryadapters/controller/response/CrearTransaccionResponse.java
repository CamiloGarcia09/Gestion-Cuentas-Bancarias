package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.Response;

import java.util.ArrayList;

public final class CrearTransaccionResponse extends Response<CrearTransaccionDTO> {

    public CrearTransaccionResponse(){
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
