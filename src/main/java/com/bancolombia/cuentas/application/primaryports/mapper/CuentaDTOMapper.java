package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CuentaDTOMapper {

    @Mapping(source = "saldoInicial", target = "saldo")
    CuentaDomain toDomain(CrearCuentaDTO dto);

    CrearCuentaDTO toDTO(CuentaDomain domain);
}
