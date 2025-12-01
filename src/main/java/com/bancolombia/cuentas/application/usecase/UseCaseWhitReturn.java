package com.bancolombia.cuentas.application.usecase;

public interface UseCaseWhitReturn <D, R> {

    R execute(D domain);
}
