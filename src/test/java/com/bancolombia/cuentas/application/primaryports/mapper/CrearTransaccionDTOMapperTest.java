package com.bancolombia.cuentas.application.primaryports.mapper;

import com.bancolombia.cuentas.application.primaryports.dto.CrearTransaccionDTO;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import com.bancolombia.cuentas.domain.transaccion.TransaccionDomain;
import com.bancolombia.cuentas.domain.transaccion.enums.TipoTransaccion;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CrearTransaccionDTOMapperTest {

    private final CrearTransaccionDTOMapper mapper =
            Mappers.getMapper(CrearTransaccionDTOMapper.class);

    @Test
    void toDomain_deberiaMapearCorrectamente() {
        UUID cuentaId = UUID.randomUUID();

        var dto = new CrearTransaccionDTO(
                cuentaId,
                TipoTransaccion.DEPOSITO,
                BigDecimal.TEN,
                "Pago"
        );

        TransaccionDomain domain = mapper.toDomain(dto);

        assertThat(domain.getTipoTransaccion()).isEqualTo(TipoTransaccion.DEPOSITO);
        assertThat(domain.getMonto()).isEqualTo(BigDecimal.TEN);
        assertThat(domain.getDescripcion()).isEqualTo("Pago");

        assertThat(domain.getCuenta()).isNotNull();
        assertThat(domain.getCuenta().getId()).isEqualTo(cuentaId);
    }

    @Test
    void toDTO_deberiaMapearCorrectamente() {
        UUID id = UUID.randomUUID();
        UUID cuentaId = UUID.randomUUID();

        var domain = TransaccionDomain.create(
                id,
                TipoTransaccion.RETIRO,
                "Compra",
                BigDecimal.ONE,
                LocalDateTime.now(),
                CuentaDomain.create(cuentaId, null, null, null)
        );

        var dto = mapper.toDTO(domain);

        assertThat(dto.getCuentaId()).isEqualTo(cuentaId);
        assertThat(dto.getTipoTransaccion()).isEqualTo(TipoTransaccion.RETIRO);
        assertThat(dto.getMonto()).isEqualTo(BigDecimal.ONE);
        assertThat(dto.getDescripcion()).isEqualTo("Compra");
    }
}
