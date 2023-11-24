package io.github.paulovieirajr.msclientes.core.usecases;


import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.api.exception.BusinessException;
import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCaseHandler;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientFindByCpfUseCaseTest {

    public static final String VALID_CPF = "56010962013";
    public static final String INVALID_CPF = "12345678901";

    @InjectMocks
    private ClientFindByCpfUseCaseHandler clientFindByCpfUseCaseHandler;

    @Mock
    private ClientRepositoryGateway clientRepositoryGateway;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should return client response when CPF is valid and client exists")
    @Test
    public void validCpfAndClientExists() {
        ClientModel clientModel = new ClientModel();
        clientModel.setCpf(VALID_CPF);
        when(clientRepositoryGateway.findByCpf(VALID_CPF)).thenReturn(Optional.of(clientModel));

        ClientResponse clientResponse = clientFindByCpfUseCaseHandler.execute(VALID_CPF);

        assertNotNull(clientResponse);
        assertEquals(VALID_CPF, clientResponse.cpf());
    }

    @DisplayName("Should throw EntityNotFoundException when CPF is valid but client does not exist")
    @Test
    public void validCpfAndClientDoesNotExist() {
        when(clientRepositoryGateway.findByCpf(VALID_CPF)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clientFindByCpfUseCaseHandler.execute(VALID_CPF));
    }

    @DisplayName("Should throw BusinessException when CPF is invalid")
    @Test
    public void invalidCpf() {
        assertThrows(BusinessException.class, () -> clientFindByCpfUseCaseHandler.execute(INVALID_CPF));
    }
}