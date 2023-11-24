package io.github.paulovieirajr.msclientes.api.controller;

import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.github.paulovieirajr.msclientes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.msclientes.api.constants.ClientControllerConstants.CLIENTS;

@RestController
@RequestMapping(API_VERSION + CLIENTS)
public class ClientFindByCpfController {

    private final ClientFindByCpfUseCase clientClientFindByCpfUseCase;

    public ClientFindByCpfController(ClientFindByCpfUseCase clientClientFindByCpfUseCase) {
        this.clientClientFindByCpfUseCase = clientClientFindByCpfUseCase;
    }

    @GetMapping
    public ResponseEntity<ClientResponse> execute(@RequestParam String cpf) {
        return ResponseEntity.ok(clientClientFindByCpfUseCase.execute(cpf));
    }
}
