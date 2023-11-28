package io.github.paulovieirajr.mscartoes.api.dto.creditcard;

import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;

import java.math.BigDecimal;
import java.util.Collection;

public record CreditCardResponse(
        String name,
        CardNetwork cardNetwork,
        BigDecimal limit
) {
    public static Collection<CreditCardResponse> fromCollection(Collection<CreditCardModel> creditCards) {
        return creditCards.stream()
                .map(CreditCardResponse::from)
                .toList();
    }

    private static CreditCardResponse from(CreditCardModel creditCardModel) {
        return new CreditCardResponse(
                creditCardModel.getName(),
                creditCardModel.getCardNetwork(),
                creditCardModel.getCreditLimit()
        );
    }
}
