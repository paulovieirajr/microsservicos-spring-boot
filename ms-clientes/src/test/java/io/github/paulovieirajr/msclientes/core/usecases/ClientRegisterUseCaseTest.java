package io.github.paulovieirajr.msclientes.core.usecases;


import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.api.exception.BusinessException;
import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCaseHandler;
import io.github.paulovieirajr.msclientes.core.domain.entities.Client;
import io.github.paulovieirajr.msclientes.core.domain.exception.ClientException;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClientRegisterUseCaseTest {

    public static final long ID = 1L;
    public static final String CLIENT_NAME = "John Doe";
    public static final String VALID_CPF = "56010962013";
    public static final int CLIENT_AGE = 30;
    public static final String INVALID_CPF = "12345678901";

    @InjectMocks
    private ClientRegisterUseCaseHandler clientRegisterUseCaseHandler;

    @Mock
    private ClientRepositoryGateway clientRepositoryGateway;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should return client response when client registration is successful")
    @Test
    public void successfulClientRegistration() {
        ClientRequest clientRequest = new ClientRequest(CLIENT_NAME, VALID_CPF, CLIENT_AGE);
        ClientModel clientModel = new ClientModel(CLIENT_NAME, VALID_CPF, CLIENT_AGE);
        clientModel.setId(ID);

        when(clientRepositoryGateway.save(any(Client.class))).thenReturn(clientModel);

        ClientResponse clientResponse = clientRegisterUseCaseHandler.execute(clientRequest);

        assertEquals(ID, clientResponse.id());
        assertEquals(CLIENT_NAME, clientResponse.name());
        assertEquals(VALID_CPF, clientResponse.cpf());
        assertEquals(CLIENT_AGE, clientResponse.age());
    }

    @DisplayName("Should throw BusinessException when client registration fails")
    @Test
    public void failedClientRegistration() {
        ClientRequest clientRequest = new ClientRequest(CLIENT_NAME, INVALID_CPF, CLIENT_AGE);
        when(clientRepositoryGateway.save(any(Client.class))).thenThrow(new ClientException("CPF Inválido"));

        assertThrows(ClientException.class, () -> clientRegisterUseCaseHandler.execute(clientRequest));
    }
}