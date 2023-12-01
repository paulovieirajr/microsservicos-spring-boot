package io.github.paulovieirajr.msavaliadorcredito.infra.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetRangeByIncomeGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import io.github.paulovieirajr.msavaliadorcredito.infra.clients.CreditCardResourceClient;

import java.util.Collection;

public class GetRangeByIncome implements GetRangeByIncomeGateway {

    private final CreditCardResourceClient creditCardResourceClient;

    public GetRangeByIncome(CreditCardResourceClient creditCardResourceClient) {
        this.creditCardResourceClient = creditCardResourceClient;
    }

    @Override
    public Collection<CreditCardClient> execute(Long income) {
        return creditCardResourceClient.findByIncome(income).getBody();
    }
}
