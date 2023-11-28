package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcard.find;

import io.github.paulovieirajr.mscartoes.api.dto.creditcard.CreditCardResponse;
import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcard.CreditCardRepositoryGateway;

import java.util.Collection;

public class CreditCardFindByIncomeUseCaseHandler implements CreditCardFindByIncomeUseCase {

    private final CreditCardRepositoryGateway creditCardRepositoryGateway;

    public CreditCardFindByIncomeUseCaseHandler(CreditCardRepositoryGateway creditCardRepositoryGateway) {
        this.creditCardRepositoryGateway = creditCardRepositoryGateway;
    }

    @Override
    public Collection<CreditCardResponse> execute(Long income) {
        var creditCards = creditCardRepositoryGateway.findByIncomeLessThanEqual(income);
        return CreditCardResponse.fromCollection(creditCards);
    }
}
