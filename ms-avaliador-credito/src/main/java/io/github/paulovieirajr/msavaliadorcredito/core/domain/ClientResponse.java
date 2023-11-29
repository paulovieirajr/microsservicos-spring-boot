package io.github.paulovieirajr.msavaliadorcredito.core.domain;

public record ClientResponse(
        Long id,
        String name,
        String cpf,
        Integer age
) {
}
