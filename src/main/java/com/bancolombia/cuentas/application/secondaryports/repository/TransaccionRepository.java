package com.bancolombia.cuentas.application.secondaryports.repository;

import com.bancolombia.cuentas.application.secondaryports.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionEntity, UUID> {
}
