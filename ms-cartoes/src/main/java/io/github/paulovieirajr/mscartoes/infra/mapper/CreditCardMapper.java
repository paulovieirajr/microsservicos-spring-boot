package io.github.paulovieirajr.mscartoes.infra.mapper;

import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCardModel toModel(CreditCard creditCard) {
        return new CreditCardModel(
                creditCard.getName(),
                creditCard.getCardNetwork(),
                creditCard.getIncome(),
                creditCard.getLimit()
        );
    }
}
