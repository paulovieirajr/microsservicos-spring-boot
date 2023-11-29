package io.github.paulovieirajr.msavaliadorcredito.core.domain;

import org.springframework.http.ResponseEntity;

public record ClientData(
        Long id,
        String name
) {

    public static ClientData of(ResponseEntity<ClientResponse> clientResponse) {
        return new ClientData(
                clientResponse.getBody().id(),
                clientResponse.getBody().name());
    }
}
