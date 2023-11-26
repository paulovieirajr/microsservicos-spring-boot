package io.github.paulovieirajr.mscartoes.core.domain;

import io.github.paulovieirajr.mscartoes.core.domain.exception.CreditCardException;

import java.math.BigDecimal;

public class CreditCard {

    private String name;
    private CardNetwork cardNetwork;
    private BigDecimal income;
    private BigDecimal limit;

    public CreditCard(String name, CardNetwork cardNetwork, BigDecimal income, BigDecimal limit) {
        canCreateCreditCard(income);
        this.name = name;
        this.cardNetwork = cardNetwork;
        this.income = income;
        this.limit = limit;
    }

    private void canCreateCreditCard(BigDecimal income) {
        if (income.compareTo(new BigDecimal(1500)) < 0) {
            throw new CreditCardException("A renda mínima para a criação de um cartão de crédito é de R$ 1500,00");
        }
    }

    public String getName() {
        return name;
    }

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public BigDecimal getLimit() {
        return limit;
    }
}
