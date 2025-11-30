package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultarSaldoCuentaDTOMapper {

    CuentaDomain toDomain(ConsultarSaldoCuentaDTO dto);

    ConsultarSaldoCuentaDTO toDTO(CuentaDomain domain);

}
