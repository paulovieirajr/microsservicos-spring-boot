package io.github.paulovieirajr.msavaliadorcredito.core.domain;

import java.math.BigDecimal;

public record CreditCardClient(
        String name,
        CardNetwork cardNetwork,
        BigDecimal creditLimit
) {
}
