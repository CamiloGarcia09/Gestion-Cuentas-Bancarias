package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.rest;


import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.crearcuenta.CrearCuentaInteractor;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response.CrearCuentaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CrearCuentaController {

    private final CrearCuentaInteractor crearCuentaInteractor;

    public CrearCuentaController(final CrearCuentaInteractor crearCuentaInteractor) {
        this.crearCuentaInteractor = crearCuentaInteractor;
    }

    @PostMapping
    public ResponseEntity<CrearCuentaResponse> execute(@RequestBody CrearCuentaDTO dto) {

        var cuentaResponse = new CrearCuentaResponse();

        crearCuentaInteractor.execute(dto);
        cuentaResponse.getMensajes().add("Cuenta creada correctamente...");

        return new ResponseEntity<>(cuentaResponse, HttpStatus.ACCEPTED);

    }

}
