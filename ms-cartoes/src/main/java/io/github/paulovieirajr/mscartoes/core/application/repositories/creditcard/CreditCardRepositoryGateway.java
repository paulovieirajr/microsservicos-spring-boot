package io.github.paulovieirajr.mscartoes.core.application.repositories.creditcard;

import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;

import java.util.Collection;

public interface CreditCardRepositoryGateway {

    CreditCardModel save(CreditCard client);

    Collection<CreditCardModel> findByIncomeLessThanEqual(Long income);
}
