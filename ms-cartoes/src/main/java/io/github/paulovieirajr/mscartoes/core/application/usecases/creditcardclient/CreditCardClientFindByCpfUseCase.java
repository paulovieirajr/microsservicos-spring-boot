package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient;

import io.github.paulovieirajr.mscartoes.api.dto.creditcardclient.CreditCardClientResponse;
import io.github.paulovieirajr.mscartoes.core.application.usecases.UseCase;

import java.util.Collection;

public interface CreditCardClientFindByCpfUseCase extends UseCase<String, Collection<CreditCardClientResponse>> {
}
