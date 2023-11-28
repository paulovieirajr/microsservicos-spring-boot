package io.github.paulovieirajr.mscartoes.infra.gateways.creditcardclient;

import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcardclient.CreditCardClientRepositoryGateway;
import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;
import io.github.paulovieirajr.mscartoes.infra.repositories.creditcardclient.CreditCardClientModelRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class CreditCardClientRepositoryGatewayJpa implements CreditCardClientRepositoryGateway {

    private final CreditCardClientModelRepository repository;

    public CreditCardClientRepositoryGatewayJpa(CreditCardClientModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<CreditCardClientModel> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
