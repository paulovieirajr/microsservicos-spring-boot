package io.github.paulovieirajr.mscartoes.core.domain;

import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.core.domain.exception.CreditCardException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    @DisplayName("Should create a credit card when income is above minimum")
    void shouldCreateCreditCardWhenIncomeIsAboveMinimum() {
        assertDoesNotThrow(() -> new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000")));
    }

    @Test
    @DisplayName("Should not create a credit card when income is below minimum")
    void shouldNotCreateCreditCardWhenIncomeIsBelowMinimum() {
        assertThrows(CreditCardException.class, () -> new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("1000"), new BigDecimal("5000")));
    }

    @Test
    @DisplayName("Should return correct card name")
    void shouldReturnCorrectCardName() {
        CreditCard creditCard = new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        assertEquals("Test Card", creditCard.getName());
    }

    @Test
    @DisplayName("Should return correct card network")
    void shouldReturnCorrectCardNetwork() {
        CreditCard creditCard = new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        assertEquals(CardNetwork.VISA, creditCard.getCardNetwork());
    }

    @Test
    @DisplayName("Should return correct income")
    void shouldReturnCorrectIncome() {
        CreditCard creditCard = new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        assertEquals(new BigDecimal("2000"), creditCard.getIncome());
    }

    @Test
    @DisplayName("Should return correct creditLimit")
    void shouldReturnCorrectLimit() {
        CreditCard creditCard = new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        assertEquals(new BigDecimal("5000"), creditCard.getLimit());
    }
}