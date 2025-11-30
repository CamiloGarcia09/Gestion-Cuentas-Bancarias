package com.bancolombia.cuentas.infrastructure.primaryadapters.controller.rest;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.application.primaryports.interactor.historialtransaccion.HistorialTransaccionInteractor;
import com.bancolombia.cuentas.infrastructure.primaryadapters.controller.response.HistorialTransaccionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class HistorialTransaccionController {

    private final HistorialTransaccionInteractor historialTransaccionInteractor;

    public HistorialTransaccionController(final HistorialTransaccionInteractor historialTransaccionInteractor) {
        this.historialTransaccionInteractor = historialTransaccionInteractor;
    }

    @GetMapping("/{id}/transacciones")
    public ResponseEntity<HistorialTransaccionResponse> execute(@PathVariable final UUID id) {

        var httpStatus = HttpStatus.ACCEPTED;
        var response = new HistorialTransaccionResponse();

        try {
            List<HistorialTransaccionDTO> transacciones = historialTransaccionInteractor.execute(id);
            response.setDatos(transacciones);
            response.getMensajes().add("Historial de Transacciones consultado correctamente...");

        } catch (final Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.getMensajes().add("Ocurrió un error consultando el historial.");
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
