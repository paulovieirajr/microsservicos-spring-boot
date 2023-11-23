package io.github.paulovieirajr.msclientes.core.usecases;

import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.infra.repository.ClientRepository;

public class ClientRegisterUseCase implements ClientUseCaseHandler <ClientRequest, ClientResponse>{

    private final ClientRepository clientRepository;

    public ClientRegisterUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponse execute(ClientRequest clientRequest) {
        var clientSaved = clientRepository.save(clientRequest.toModel());
        return new ClientResponse(clientSaved.getId(), clientSaved.getName(), clientSaved.getCpf(), clientSaved.getAge());
    }
}
