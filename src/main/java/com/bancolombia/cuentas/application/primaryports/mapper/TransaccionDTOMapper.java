package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CuentaDTOMapper.class})
public interface TransaccionDTOMapper {

    @Mapping(source = "cuentaId", target = "cuenta.id")
    TransaccionDomain toDomain(CrearTransaccionDTO dto);

    @Mapping(source = "cuenta.id", target = "cuentaId")
    CrearTransaccionDTO toDTO(TransaccionDomain domain);

    List<CrearTransaccionDTO> toDTOList(List<TransaccionDomain> domainList);
    List<TransaccionDomain> toDomainList(List<CrearTransaccionDTO> dtoList);
}

