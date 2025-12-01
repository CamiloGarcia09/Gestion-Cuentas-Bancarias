package com.bancolombia.cuentas.application.secondaryports.mapper;

import com.bancolombia.cuentas.application.secondaryports.entity.TransaccionEntity;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring", uses = { CuentaEntityMapper.class }
)
public interface TransaccionEntityMapper {

    TransaccionEntity toEntity(TransaccionDomain domain);

    @InheritInverseConfiguration
    TransaccionDomain toDomain(TransaccionEntity entity);

    List<TransaccionEntity> toEntities(List<TransaccionDomain> domains);
    List<TransaccionDomain> toDomains(List<TransaccionEntity> entities);
}

