package io.github.paulovieirajr.msclientes.core.usecases;


import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCaseHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClientClientRegisterUseCaseHandlerTest {

    @Autowired
    ClientRegisterUseCaseHandler clientClientRegisterUseCaseHandler;

    @Test
    @DisplayName("Should return a a client response when client is created")
    void createClient() {
        var clientRequest = new ClientRequest("John Doe", "56010962013", 30);
        var clientResponse = clientClientRegisterUseCaseHandler.execute(clientRequest);
        assertNotNull(clientResponse);
    }
}