package io.github.paulovieirajr.mscartoes.core.application.repositories;

import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.model.CreditCardModel;

import java.util.Collection;

public interface CreditCardRepositoryGateway {

    CreditCardModel save(CreditCard client);

    Collection<CreditCardModel> findByIncomeLessThanEqual(Long income);
}
