package io.github.paulovieirajr.msavaliadorcredito.core.application.model;

import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CPF;

public record ClientDataAssessmentRequest(
        @CPF(message = "CPF inválido")
        String cpf,

        @Positive(message = "Renda deve ser maior que zero")
        Long income
) {
}
