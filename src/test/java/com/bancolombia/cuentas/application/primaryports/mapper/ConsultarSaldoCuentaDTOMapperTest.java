package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.ConsultarSaldoCuentaDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ConsultarSaldoCuentaDTOMapperTest {

    private final ConsultarSaldoCuentaDTOMapper mapper =
            Mappers.getMapper(ConsultarSaldoCuentaDTOMapper.class);

    @Test
    void toDTO_deberiaMapearCorrectamente() {
        var domain = CuentaDomain.create(
                UUID.randomUUID(),
                "123",
                "Juan",
                BigDecimal.TEN
        );

        var dto = mapper.toDTO(domain);

        assertThat(dto.getNombreTitular()).isEqualTo("Juan");
        assertThat(dto.getSaldo()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void toDomain_deberiaMapearCorrectamente() {
        var dto = new ConsultarSaldoCuentaDTO("Maria", BigDecimal.ONE);

        var domain = mapper.toDomain(dto);

        assertThat(domain.getNombreTitular()).isEqualTo("Maria");
        assertThat(domain.getSaldo()).isEqualTo(BigDecimal.ONE);
    }
}