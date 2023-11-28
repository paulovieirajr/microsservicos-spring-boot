package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcard.find;

import io.github.paulovieirajr.mscartoes.api.dto.creditcard.CreditCardResponse;
import io.github.paulovieirajr.mscartoes.core.application.usecases.UseCase;

import java.util.Collection;

public interface CreditCardFindByIncomeUseCase extends UseCase<Long, Collection<CreditCardResponse>> {

}
