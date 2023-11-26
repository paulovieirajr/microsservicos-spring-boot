package io.github.paulovieirajr.mscartoes.core.application.usecases;

import io.github.paulovieirajr.mscartoes.api.dto.CreditCardRequest;
import io.github.paulovieirajr.mscartoes.api.dto.CreditCardResponse;
import io.github.paulovieirajr.mscartoes.core.application.repositories.CreditCardRepositoryGateway;

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
