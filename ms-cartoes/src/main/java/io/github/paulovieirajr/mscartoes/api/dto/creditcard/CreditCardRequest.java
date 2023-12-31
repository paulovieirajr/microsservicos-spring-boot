package io.github.paulovieirajr.mscartoes.api.dto.creditcard;

import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreditCardRequest(
        @NotBlank(message = "O nome do cartão não pode ser vazio")
        String name,
        @NotNull(message = "A bandeira do cartão não pode ser vazia")
        CardNetwork cardNetwork,
        @Positive(message = "A renda mínima para a criação não pode ser menor que zero")
        @Min(value = 1500, message = "A renda mínima para a criação de um cartão é de R$ 1.500,00")
        BigDecimal income,
        @Positive(message = "O limite do cartão não pode ser menor que zero")
        BigDecimal limit
) {

    public CreditCard toDomain() {
        return new CreditCard(name, cardNetwork, income, limit);
    }
}
