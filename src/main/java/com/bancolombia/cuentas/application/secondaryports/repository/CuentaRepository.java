package com.bancolombia.cuentas.application.secondaryports.repository;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuentaRepository extends JpaRepository <CuentaEntity, UUID> {

    boolean existsByNumeroCuenta(String numeroCuenta);
}
