package io.github.paulovieirajr.msavaliadorcredito.core.domain;

import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;

public record CreditCardClient(
        String name,
        CardNetwork cardNetwork,
        BigDecimal creditLimit
) {
}
