package io.github.paulovieirajr.msclientes.infra.gateways;

import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.domain.entities.Client;
import io.github.paulovieirajr.msclientes.infra.mapper.ClientMapper;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import io.github.paulovieirajr.msclientes.infra.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientRepositoryGatewayJpa implements ClientRepositoryGateway {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientRepositoryGatewayJpa(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientModel save(Client client) {
        return clientRepository.save(clientMapper.toModel(client));
    }

    @Override
    public Optional<ClientModel> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
