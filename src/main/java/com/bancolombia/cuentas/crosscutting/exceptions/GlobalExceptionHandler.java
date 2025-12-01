package com.bancolombia.cuentas.crosscutting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.exc.InvalidFormatException;

import java.util.Arrays;
import java.util.Map;

@ControllerAdvice
public final class GlobalExceptionHandler {

    private static final String ENCABEZADO = "Error";

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(Map.of(ENCABEZADO, ex.getReason()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormat(HttpMessageNotReadableException ex) {

        Throwable cause = ex.getCause();

        // Caso: ENUM inválido
        if (cause instanceof InvalidFormatException invalidFormat &&
                invalidFormat.getTargetType().isEnum()) {

            String valores = Arrays.toString(invalidFormat.getTargetType().getEnumConstants());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            ENCABEZADO,
                            "El valor '" + invalidFormat.getValue() + "' no es válido. Valores permitidos: " + valores
                    ));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(ENCABEZADO, "El formato del cuerpo enviado no es válido."));
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParams(MissingServletRequestParameterException ex) {
        String message = String.format(
                "Falta el parámetro requerido: '%s'.",
                ex.getParameterName()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(ENCABEZADO, message));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(ENCABEZADO, ex.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of(ENCABEZADO, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAll(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(ENCABEZADO, "Ocurrió un error inesperado."));
    }
}