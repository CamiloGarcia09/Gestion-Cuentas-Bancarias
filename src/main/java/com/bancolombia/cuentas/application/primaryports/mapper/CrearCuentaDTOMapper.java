package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CrearCuentaDTOMapper {

    @Mapping(source = "saldoInicial", target = "saldo")
    CuentaDomain toDomain(CrearCuentaDTO dto);

    @InheritInverseConfiguration
    CrearCuentaDTO toDTO(CuentaDomain domain);
}
