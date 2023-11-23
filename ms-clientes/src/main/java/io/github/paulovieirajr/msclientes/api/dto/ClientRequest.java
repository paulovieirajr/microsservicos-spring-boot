package io.github.paulovieirajr.msclientes.api.dto;

import io.github.paulovieirajr.msclientes.core.domain.Client;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

    public ClientModel toModel() {
        Client client = new Client(name, cpf, age);
        return new ClientModel(client.getName(), client.getCpf(), client.getAge());
    }
}
