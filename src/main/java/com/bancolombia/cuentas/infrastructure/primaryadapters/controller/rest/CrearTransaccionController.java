package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.rest;


import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.creartransaccion.CrearTransaccionInteractor;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response.CrearTransaccionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transacciones")
public class CrearTransaccionController {

    private final CrearTransaccionInteractor crearTransaccionInteractor;

    public CrearTransaccionController(final CrearTransaccionInteractor crearTransaccionInteractor) {
        this.crearTransaccionInteractor = crearTransaccionInteractor;
    }

    @PostMapping
    public ResponseEntity<CrearTransaccionResponse> execute(@RequestBody CrearTransaccionDTO dto) {

        var transaccionResponse = new CrearTransaccionResponse();

        crearTransaccionInteractor.execute(dto);
        transaccionResponse.getMensajes().add("Transaccion realizada correctamente...");

        return new ResponseEntity<>(transaccionResponse, HttpStatus.ACCEPTED);

    }

}
