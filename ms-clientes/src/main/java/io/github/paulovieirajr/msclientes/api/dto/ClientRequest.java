package io.github.paulovieirajr.msclientes.api.dto;

import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ClientRequest(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "CPF é obrigatório")
        @CPF(message = "CPF inválido")
        String cpf,

        @NotNull(message = "Idade é obrigatória")
        @Min(value = 1, message = "A idade deve ser maior que 0")
        Integer age
) {

    public ClientModel toModel() {
        return new ClientModel(name, cpf, age);
    }
}
