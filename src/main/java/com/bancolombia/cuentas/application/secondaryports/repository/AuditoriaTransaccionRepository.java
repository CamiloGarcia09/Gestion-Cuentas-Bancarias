package com.bancolombia.cuentas.application.secondaryports.repository;

import com.bancolombia.cuentas.application.secondaryports.entity.AuditoriaTransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditoriaTransaccionRepository extends JpaRepository<AuditoriaTransaccionEntity, UUID> {
}
