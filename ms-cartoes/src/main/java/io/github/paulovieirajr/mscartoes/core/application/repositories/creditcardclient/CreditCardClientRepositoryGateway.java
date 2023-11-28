package io.github.paulovieirajr.mscartoes.core.application.repositories.creditcardclient;

import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;

import java.util.Collection;

public interface CreditCardClientRepositoryGateway {

    Collection<CreditCardClientModel> findByCpf(String cpf);
}
