package io.github.paulovieirajr.msclientes.api.controller;

import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.usecases.ClientRegisterUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static io.github.paulovieirajr.msclientes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.msclientes.api.constants.ClientControllerConstants.CLIENTS;

@RestController
@RequestMapping(API_VERSION + CLIENTS)
public class ClientRegisterController {

    private final ClientRegisterUseCase clientRegisterUseCase;

    public ClientRegisterController(ClientRegisterUseCase clientRegisterUseCase) {
        this.clientRegisterUseCase = clientRegisterUseCase;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> execute(@Valid @RequestBody ClientRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRegisterUseCase.execute(request));
    }
}
