package io.github.paulovieirajr.msclientes.api.dto;

import io.github.paulovieirajr.msclientes.core.domain.entities.Client;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ClientRequest(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "CPF é obrigatório")
        @CPF(message = "CPF inválido")
        String cpf,

        @NotNull(message = "Idade é obrigatória")
        @Positive(message = "Idade deve ser maior que zero")
        Integer age
) {

    public Client toEntity() {
        return new Client(name, cpf, age);
    }
}
