package io.github.paulovieirajr.msavaliadorcredito.core.application.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;

import java.util.Collection;

public interface GetCreditCardByCpfGateway {

    Collection<CreditCardClient> execute(String cpf);
}
