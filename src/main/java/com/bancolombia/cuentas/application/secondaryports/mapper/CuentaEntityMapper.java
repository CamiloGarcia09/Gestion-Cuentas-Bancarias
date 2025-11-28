package com.bancolombia.cuentas.application.secondaryports.mapper;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaEntityMapper {

    //Puedo quitar el mapper si los atributos son identicos
    @Mappings({
            @Mapping(source = "id",            target = "id"),
            @Mapping(source = "numeroCuenta",  target = "numeroCuenta"),
            @Mapping(source = "nombreTitular", target = "nombreTitular"),
            @Mapping(source = "saldo",         target = "saldo")
    })
    CuentaEntity toEntity(CuentaDomain domain);

    @InheritInverseConfiguration
    CuentaDomain toDomain(CuentaEntity entity);


    List<CuentaEntity> toEntities(List<CuentaDomain> domains);
    List<CuentaDomain> toDomains(List<CuentaEntity> entities);
}
