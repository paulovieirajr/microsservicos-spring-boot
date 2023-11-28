package io.github.paulovieirajr.mscartoes.api.dto.creditcardclient;

import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;

import java.math.BigDecimal;
import java.util.Collection;

public record CreditCardClientResponse(
        String name,
        String cardNetwork,
        BigDecimal creditLimit
) {

    public static Collection<CreditCardClientResponse> fromCollection(Collection<CreditCardClientModel> creditCardClientModels) {
        return creditCardClientModels.stream()
                .map(CreditCardClientResponse::from)
                .toList();
    }

    private static CreditCardClientResponse from(CreditCardClientModel creditCardClientModel) {
        return new CreditCardClientResponse(
                creditCardClientModel.getCreditCard().getName(),
                creditCardClientModel.getCreditCard().getCardNetwork().name(),
                creditCardClientModel.getCreditLimit()
        );
    }
}
