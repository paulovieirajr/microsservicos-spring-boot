package io.github.paulovieirajr.mscartoes.core.application.usecases;

import io.github.paulovieirajr.mscartoes.api.dto.CreditCardResponse;

import java.util.Collection;

public interface CreditCardFindByIncomeUseCase extends UseCase<Long, Collection<CreditCardResponse>> {

}
