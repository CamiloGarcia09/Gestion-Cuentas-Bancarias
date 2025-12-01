package com.bancolombia.cuentas.application.primaryports.interactor;

public interface InteractorWithReturn<T, R>{

    R execute(T data);
}
