package io.github.paulovieirajr.msclientes.api.dto;

import io.github.paulovieirajr.msclientes.core.exception.ClientException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientRequestTest {

    @Test
    @DisplayName("Should create ClientModel when ClientRequest is valid and convert to model")
    void shouldCreateClientModelWhenClientRequestIsValid() {
        ClientRequest clientRequest = new ClientRequest("John Doe", "56010962013", 30);
        assertNotNull(clientRequest.toModel());
    }

    @Test
    @DisplayName("Should throw ClientException when name is blank and convert to model")
    void shouldThrowClientExceptionWhenNameIsBlank() {
        assertThrows(ClientException.class, () -> new ClientRequest("", "56010962013", 30).toModel());
    }

    @Test
    @DisplayName("Should throw ClientException when CPF is invalid and convert to model")
    void shouldThrowClientExceptionWhenCPFIsInvalid() {
        assertThrows(ClientException.class, () -> new ClientRequest("John Doe", "123", 30).toModel());
    }

    @Test
    @DisplayName("Should throw ClientException when age is not positive and convert to model")
    void shouldThrowClientExceptionWhenAgeIsNotPositive() {
        assertThrows(ClientException.class, () -> new ClientRequest("John Doe", "56010962013", 0).toModel());
    }
}