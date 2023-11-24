package io.github.paulovieirajr.msclientes.api.controller;

import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;

import static io.github.paulovieirajr.msclientes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.msclientes.api.constants.ClientControllerConstants.CLIENTS;

@RestController
@RequestMapping(API_VERSION + CLIENTS)
public class ClientRegisterController {

    private final ClientRegisterUseCase clientClientRegisterUseCaseHandler;

    public ClientRegisterController(ClientRegisterUseCase clientClientRegisterUseCase) {
        this.clientClientRegisterUseCaseHandler = clientClientRegisterUseCase;
    }

    @PostMapping
    public ResponseEntity<?> execute(@Valid @RequestBody ClientRequest request) {
        clientClientRegisterUseCaseHandler.execute(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(request.cpf())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
