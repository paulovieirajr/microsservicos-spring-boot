package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient;

import io.github.paulovieirajr.mscartoes.api.dto.creditcardclient.CreditCardClientResponse;
import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcardclient.CreditCardClientRepositoryGateway;
import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;

import java.util.Collection;

public class CreditCardClientFindByCpfUseCaseHandler implements CreditCardClientFindByCpfUseCase {

    private final CreditCardClientRepositoryGateway creditCardClientRepositoryGateway;

    public CreditCardClientFindByCpfUseCaseHandler(CreditCardClientRepositoryGateway creditCardClientRepositoryGateway) {
        this.creditCardClientRepositoryGateway = creditCardClientRepositoryGateway;
    }

    @Override
    public Collection<CreditCardClientResponse> execute(String cpf) {
        Collection<CreditCardClientModel> creditCardClientModelCollection = creditCardClientRepositoryGateway.findByCpf(cpf);
        return CreditCardClientResponse.fromCollection(creditCardClientModelCollection);
    }
}
