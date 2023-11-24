package io.github.paulovieirajr.msclientes.core.application.usecases;

import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;

public class ClientRegisterUseCase implements ClientUseCaseHandler <ClientRequest, ClientResponse>{

    private final ClientRepositoryGateway clientRepositoryGateway;

    public ClientRegisterUseCase(ClientRepositoryGateway clientRepositoryGateway) {
        this.clientRepositoryGateway = clientRepositoryGateway;
    }


    @Override
    public ClientResponse execute(ClientRequest clientRequest) {
        var clientSaved = clientRepositoryGateway.save(clientRequest.toEntity());
        return new ClientResponse(clientSaved.getId(), clientSaved.getName(), clientSaved.getCpf(), clientSaved.getAge());
    }
}
