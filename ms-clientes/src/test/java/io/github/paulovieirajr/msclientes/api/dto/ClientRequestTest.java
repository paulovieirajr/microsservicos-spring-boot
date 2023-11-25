package io.github.paulovieirajr.msclientes.api.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientRequestTest {

    @Test
    @DisplayName("Should create ClientModel when ClientRequest is valid and convert to model")
    void shouldCreateClientModelWhenClientRequestIsValid() {
        ClientRequest clientRequest = new ClientRequest("John Doe", "56010962013", 30);
        assertNotNull(clientRequest.toEntity());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when name is blank and convert to model")
    void shouldThrowIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new ClientRequest("", "56010962013", 30).toEntity());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when CPF is invalid and convert to model")
    void shouldThrowIllegalArgumentExceptionWhenCPFIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new ClientRequest("John Doe", "123", 30).toEntity());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when age is not positive and convert to model")
    void shouldThrowIllegalArgumentExceptionWhenAgeIsNotPositive() {
        assertThrows(IllegalArgumentException.class, () -> new ClientRequest("John Doe", "56010962013", 0).toEntity());
    }
}