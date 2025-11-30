package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.rest;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.consultarsaldocuenta.ConsultarSaldoCuentaInteractor;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response.ConsultarSaldoCuentaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cuentas")
public class ConsultarSaldoCuentaController {

    private final ConsultarSaldoCuentaInteractor consultarSaldoCuentaInteractor;

    public ConsultarSaldoCuentaController(final ConsultarSaldoCuentaInteractor consultarSaldoCuentaInteractor) {
        this.consultarSaldoCuentaInteractor = consultarSaldoCuentaInteractor;
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<ConsultarSaldoCuentaResponse> execute(@PathVariable final UUID id) {

        var response = new ConsultarSaldoCuentaResponse();

        ConsultarSaldoCuentaDTO dto = consultarSaldoCuentaInteractor.execute(id);
        response.setDatos(Collections.singletonList(dto));
        response.getMensajes().add("Consulta realizada correctamente...");

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);


    }
}
