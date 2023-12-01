package io.github.paulovieirajr.msavaliadorcredito.infra.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetCreditCardByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import io.github.paulovieirajr.msavaliadorcredito.infra.clients.CreditCardResourceClient;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public class GetCreditCardByCpf implements GetCreditCardByCpfGateway {

    private final CreditCardResourceClient creditCardResourceClient;

    public GetCreditCardByCpf(CreditCardResourceClient creditCardResourceClient) {
        this.creditCardResourceClient = creditCardResourceClient;
    }

    @Override
    public Collection<CreditCardClient> execute(String cpf) {
        ResponseEntity<Collection<CreditCardClient>> creditCardResponse = creditCardResourceClient.getCreditCardsByCpf(cpf);
        return creditCardResponse.getBody();
    }
}
