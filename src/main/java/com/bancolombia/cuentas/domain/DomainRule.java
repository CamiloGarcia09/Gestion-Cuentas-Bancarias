package com.bancolombia.cuentas.domain;

public interface DomainRule<T>{

    void validate (T data);
}
