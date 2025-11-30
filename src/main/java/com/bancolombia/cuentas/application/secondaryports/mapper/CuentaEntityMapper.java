package com.bancolombia.cuentas.application.secondaryports.mapper;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaEntityMapper {


    CuentaEntity toEntity(CuentaDomain domain);

    @InheritInverseConfiguration
    CuentaDomain toDomain(CuentaEntity entity);


    List<CuentaEntity> toEntities(List<CuentaDomain> domains);
    List<CuentaDomain> toDomains(List<CuentaEntity> entities);
}
