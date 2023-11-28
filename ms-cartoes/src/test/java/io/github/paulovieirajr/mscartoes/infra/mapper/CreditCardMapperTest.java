package io.github.paulovieirajr.mscartoes.infra.mapper;

import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardMapperTest {

    @Test
    @DisplayName("Should map to model correctly")
    void shouldMapToModelCorrectly() {
        CreditCardMapper creditCardMapper = new CreditCardMapper();
        CreditCard creditCard = new CreditCard(
                "Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        CreditCardModel result = creditCardMapper.toModel(creditCard);

        assertEquals(creditCard.getName(), result.getName());
        assertEquals(creditCard.getCardNetwork(), result.getCardNetwork());
        assertEquals(creditCard.getIncome(), result.getIncome());
        assertEquals(creditCard.getLimit(), result.getCreditLimit());
    }
}