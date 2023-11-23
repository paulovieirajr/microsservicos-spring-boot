package io.github.paulovieirajr.msclientes.api.dto;

public record ClientResponse(
        Long id,
        String name,
        String cpf,
        Integer age
) {
}
