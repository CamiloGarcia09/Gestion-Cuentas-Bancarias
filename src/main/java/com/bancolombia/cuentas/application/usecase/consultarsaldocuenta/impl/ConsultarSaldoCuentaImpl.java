package com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.impl;

import com.bancolombia.cuentas.application.secondaryports.mapper.CuentaEntityMapper;
import com.bancolombia.cuentas.application.secondaryports.repository.CuentaRepository;
import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.ConsultarSaldoCuenta;
import com.bancolombia.cuentas.application.usecase.consultarsaldocuenta.validator.ConsultarSaldoCuentaRulesValidator;
import com.bancolombia.cuentas.domain.cuenta.CuentaDomain;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public final class ConsultarSaldoCuentaImpl implements ConsultarSaldoCuenta {

    private final CuentaRepository cuentaRepository;
    private final CuentaEntityMapper cuentaEntityMapper;
    private final ConsultarSaldoCuentaRulesValidator consultarSaldoCuentaRulesValidator;

    public ConsultarSaldoCuentaImpl(final CuentaRepository cuentaRepository,
                                    final CuentaEntityMapper cuentaEntityMapper,
                                    final ConsultarSaldoCuentaRulesValidator consultarSaldoCuentaRulesValidator) {
        this.cuentaRepository = cuentaRepository;
        this.cuentaEntityMapper = cuentaEntityMapper;
        this.consultarSaldoCuentaRulesValidator = consultarSaldoCuentaRulesValidator;
    }

    @Override
    public CuentaDomain execute(UUID domain) {
        consultarSaldoCuentaRulesValidator.validate(domain);

        final var resultado = cuentaRepository.findById(domain).orElseThrow(() -> new RuntimeException("Cuenta no entontrada"));
        return cuentaEntityMapper.toDomain(resultado);
    }
}
