package com.bancolombia.cuentas.application.primaryports.interactor;

public interface InteractorWithOutReturn<T> {

    void execute(T data);
}
