package io.github.paulovieirajr.msclientes.core.domain;

import io.github.paulovieirajr.msclientes.core.exception.ClientException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientTest {

    @Nested
    @DisplayName("Create Client with correct values")
    class CreateClientWithCorrectValues {

        @DisplayName("Should create a Client with correct values")
        @Test
        void createClientWithCorrectValues() {
            Client client = new Client("John Doe", "56010962013", 25);

            assertEquals("John Doe", client.getName());
            assertEquals("56010962013", client.getCpf());
            assertEquals(25, client.getAge());
        }
    }

    @Nested
    @DisplayName("Throwing exception when creating Client with incorrect values")
    class CreateClientWithIncorrectValues {
        @DisplayName("Should throw exception when name is blank")
        @Test
        void createClientWithBlankName() {
            assertThrows(ClientException.class, () -> new Client("", "56010962013", 25));
        }

        @DisplayName("Should throw exception when CPF is invalid")
        @Test
        void createClientWithInvalidCPF() {
            assertThrows(ClientException.class, () -> new Client("John Doe", "123", 25));
        }

        @DisplayName("Should throw exception when age is null")
        @Test
        void createClientWithNullAge() {
            assertThrows(ClientException.class, () -> new Client("John Doe", "56010962013", null));
        }

        @DisplayName("Should throw exception when age is not positive")
        @Test
        void createClientWithNonPositiveAge() {
            assertThrows(ClientException.class, () -> new Client("John Doe", "56010962013", 0));
        }
    }
}