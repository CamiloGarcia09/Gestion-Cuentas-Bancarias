package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearCuentaDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CrearCuentaDTOMapperTest {

    private final CrearCuentaDTOMapper mapper =
            Mappers.getMapper(CrearCuentaDTOMapper.class);

    @Test
    void toDomain_deberiaMapearSaldoInicialCorrectamente() {
        var dto = new CrearCuentaDTO("123", "Juan", BigDecimal.TEN);

        var domain = mapper.toDomain(dto);

        assertThat(domain.getNumeroCuenta()).isEqualTo("123");
        assertThat(domain.getNombreTitular()).isEqualTo("Juan");
        assertThat(domain.getSaldo()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void toDTO_deberiaMapearCorrectamente() {
        var domain = CuentaDomain.create(
                UUID.randomUUID(),
                "999",
                "Maria",
                BigDecimal.ONE
        );

        var dto = mapper.toDTO(domain);

        assertThat(dto.getNumeroCuenta()).isEqualTo("999");
        assertThat(dto.getNombreTitular()).isEqualTo("Maria");
        assertThat(dto.getSaldoInicial()).isEqualTo(BigDecimal.ONE);
    }
}
