package io.github.paulovieirajr.msavaliadorcredito.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ApprovedCreditCardClient {

    private final String name;
    private final CardNetwork cardNetwork;
    private final BigDecimal creditLimit;

    public ApprovedCreditCardClient(String name, CardNetwork cardNetwork, BigDecimal creditLimit, Integer clientAge) {
        this.name = name;
        this.cardNetwork = cardNetwork;
        this.creditLimit = calculateCreditLimit(creditLimit, clientAge);
    }

    private BigDecimal calculateCreditLimit(BigDecimal creditLimit, Integer age) {
        if (age >= 18 && age <= 35) {
            return creditLimit.multiply(BigDecimal.valueOf(1.25)).setScale(2, RoundingMode.HALF_UP);
        }
        if (age >= 36 && age <= 55) {
            return creditLimit.multiply(BigDecimal.valueOf(1.45)).setScale(2, RoundingMode.HALF_UP);
        }
        return creditLimit.multiply(BigDecimal.valueOf(1.35)).setScale(2, RoundingMode.HALF_UP);
    }

    public static Set<ApprovedCreditCardClient> mapToApprovedCreditCards(Collection<CreditCardClient> creditCardClients, ClientData clientData) {
        return creditCardClients.stream()
                .map(creditCardClient -> new ApprovedCreditCardClient(
                        creditCardClient.name(),
                        creditCardClient.cardNetwork(),
                        creditCardClient.creditLimit(),
                        clientData.age()))
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprovedCreditCardClient that = (ApprovedCreditCardClient) o;
        return Objects.equals(name, that.name) && cardNetwork == that.cardNetwork && Objects.equals(creditLimit, that.creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardNetwork, creditLimit);
    }
}
