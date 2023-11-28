package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcard.save;

import io.github.paulovieirajr.mscartoes.api.dto.creditcard.CreditCardRequest;
import io.github.paulovieirajr.mscartoes.api.dto.creditcard.CreditCardResponse;
import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcard.CreditCardRepositoryGateway;

public class CreditCardRegisterUseCaseHandler implements CreditCardRegisterUseCase {

    private final CreditCardRepositoryGateway creditCardRepositoryGateway;

    public CreditCardRegisterUseCaseHandler(CreditCardRepositoryGateway creditCardRepositoryGateway) {
        this.creditCardRepositoryGateway = creditCardRepositoryGateway;
    }

    @Override
    public CreditCardResponse execute(CreditCardRequest creditCardRequest) {
        var creditCardSaved = creditCardRepositoryGateway.save(creditCardRequest.toDomain());
        return new CreditCardResponse(
                creditCardSaved.getName(),
                creditCardSaved.getCardNetwork(),
                creditCardSaved.getCreditLimit());
    }
}
