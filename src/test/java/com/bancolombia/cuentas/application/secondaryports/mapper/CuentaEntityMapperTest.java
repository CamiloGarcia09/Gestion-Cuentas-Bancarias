package com.bancolombia.cuentas.application.secondaryports.mapper;

import com.bancolombia.cuentas.application.secondaryports.entity.CuentaEntity;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CuentaEntityMapperTest {

    private final CuentaEntityMapper mapper =
            Mappers.getMapper(CuentaEntityMapper.class);

    @Test
    void toEntity_deberiaMapearCorrectamente() {

        var domain = CuentaDomain.create(
                UUID.randomUUID(),
                "123",
                "Juan",
                BigDecimal.TEN
        );

        CuentaEntity entity = mapper.toEntity(domain);

        assertThat(entity.getId()).isEqualTo(domain.getId());
        assertThat(entity.getNumeroCuenta()).isEqualTo("123");
        assertThat(entity.getNombreTitular()).isEqualTo("Juan");
        assertThat(entity.getSaldo()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void toDomain_deberiaMapearCorrectamente() {

        var entity = CuentaEntity.create(
                UUID.randomUUID(),
                "999",
                "Maria",
                BigDecimal.ONE
        );

        CuentaDomain domain = mapper.toDomain(entity);

        assertThat(domain.getId()).isEqualTo(entity.getId());
        assertThat(domain.getNumeroCuenta()).isEqualTo("999");
        assertThat(domain.getNombreTitular()).isEqualTo("Maria");
        assertThat(domain.getSaldo()).isEqualTo(BigDecimal.ONE);
    }

    @Test
    void toDomains_y_toEntities_deberianMapearListas() {

        var entity = CuentaEntity.create(
                UUID.randomUUID(),
                "555",
                "Pedro",
                BigDecimal.valueOf(500)
        );

        var domainList = mapper.toDomains(List.of(entity));
        assertThat(domainList).hasSize(1);
        assertThat(domainList.get(0).getNumeroCuenta()).isEqualTo("555");

        var entityList = mapper.toEntities(domainList);
        assertThat(entityList).hasSize(1);
        assertThat(entityList.get(0).getNombreTitular()).isEqualTo("Pedro");
    }
}
