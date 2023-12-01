package io.github.paulovieirajr.msavaliadorcredito.core.application.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;

import java.util.Collection;

public interface GetRangeByIncomeGateway {

    Collection<CreditCardClient> execute(Long income);
}
