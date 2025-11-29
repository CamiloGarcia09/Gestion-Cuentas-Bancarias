package com.bancolombia.cuentas.application.usecase;

public interface UseCaseWhitOutReturn <D>{

    void execute(D domain);
}
