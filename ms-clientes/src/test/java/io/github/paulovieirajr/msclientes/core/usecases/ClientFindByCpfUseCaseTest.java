package io.github.paulovieirajr.msclientes.core.usecases;


import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.api.exception.BusinessException;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCase;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClientFindByCpfUseCaseTest {

    public static final String VALID_CPF_TO_SAVE = "56010962013";
    public static final String VALID_CPF_NOT_SAVED_IN_DATABASE = "88158375073";
    public static final String INVALID_CPF = "12345678901";

    @Autowired
    ClientFindByCpfUseCase clientFindByCpfUseCase;

    @Autowired
    ClientRegisterUseCase clientRegisterUseCase;

    @DisplayName("Should return client response when CPF is valid and client exists")
    @Test
    public void validCpfAndClientExists() {
        saveClient();
        ClientResponse response = clientFindByCpfUseCase.execute(VALID_CPF_TO_SAVE);
        assertNotNull(response);
    }

    @DisplayName("Should throw EntityNotFoundException when CPF is valid but client does not exist")
    @Test
    public void validCpfAndClientDoesNotExist() {
        assertThrows(EntityNotFoundException.class, () -> clientFindByCpfUseCase.execute(VALID_CPF_NOT_SAVED_IN_DATABASE));
    }

    @DisplayName("Should throw BusinessException when CPF is invalid")
    @Test
    public void invalidCpf() {
        assertThrows(BusinessException.class, () -> clientFindByCpfUseCase.execute(INVALID_CPF));
    }

    private void saveClient() {
        var clientRequest = new ClientRequest("John Doe", VALID_CPF_TO_SAVE, 30);
        clientRegisterUseCase.execute(clientRequest);
    }
}