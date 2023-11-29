package io.github.paulovieirajr.msavaliadorcredito.core.domain;

import java.util.Collection;

public record ClientStatus(
        ClientData clientData,
        Collection<CreditCardClient> creditCards
) {
}
