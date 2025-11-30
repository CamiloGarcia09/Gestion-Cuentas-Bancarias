package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistorialTransaccionDTOMapper {

    @Mapping(source = "id", target = "transaccionId")
    HistorialTransaccionDTO toDTO(TransaccionDomain domain);

    List<HistorialTransaccionDTO> toDTOList(List<TransaccionDomain> list);
}
