package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class HistorialTransaccionDTOMapperTest {

    private final HistorialTransaccionDTOMapper mapper =
            Mappers.getMapper(HistorialTransaccionDTOMapper.class);

    @Test
    void toDTO_deberiaMapearCorrectamente() {
        var domain = TransaccionDomain.create(
                UUID.randomUUID(),
                TipoTransaccion.DEPOSITO,
                "Pago",
                BigDecimal.TEN,
                LocalDateTime.now(),
                CuentaDomain.create(UUID.randomUUID(), null, null, null)
        );

        var dto = mapper.toDTO(domain);

        assertThat(dto.getTipoTransaccion()).isEqualTo(TipoTransaccion.DEPOSITO);
        assertThat(dto.getMonto()).isEqualTo(BigDecimal.TEN);
        assertThat(dto.getDescripcion()).isEqualTo("Pago");
        assertThat(dto.getFecha()).isNotNull();
    }

    @Test
    void toDTOList_deberiaMapearCorrectamente() {
        var domain = TransaccionDomain.create(
                UUID.randomUUID(),
                TipoTransaccion.RETIRO,
                "Compra",
                BigDecimal.ONE,
                LocalDateTime.now(),
                CuentaDomain.create(UUID.randomUUID(), null, null, null)
        );

        var list = mapper.toDTOList(List.of(domain));

        assertThat(list).hasSize(1);
        assertThat(list.get(0).getDescripcion()).isEqualTo("Compra");
    }
}