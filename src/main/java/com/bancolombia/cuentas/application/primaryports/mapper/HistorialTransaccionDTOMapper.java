package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.HistorialTransaccionDTO;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistorialTransaccionDTOMapper {

    HistorialTransaccionDTO toDTO(TransaccionDomain domain);

    List<HistorialTransaccionDTO> toDTOList(List<TransaccionDomain> list);
}
