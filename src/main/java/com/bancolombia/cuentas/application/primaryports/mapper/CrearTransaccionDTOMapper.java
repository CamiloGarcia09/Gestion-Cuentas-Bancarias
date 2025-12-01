package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CrearTransaccionDTOMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(source = "cuentaId", target = "cuenta", qualifiedByName = "mapCuentaIdToDomain")
    TransaccionDomain toDomain(CrearTransaccionDTO dto);

    @Mapping(source = "cuenta.id", target = "cuentaId")
    CrearTransaccionDTO toDTO(TransaccionDomain domain);

    @Named("mapCuentaIdToDomain")
    default CuentaDomain mapCuentaIdToDomain(UUID cuentaId) {
        return CuentaDomain.create(cuentaId, null, null, null);
    }
}
