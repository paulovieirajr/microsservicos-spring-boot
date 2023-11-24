package io.github.paulovieirajr.msclientes.core.application.repositories;

import io.github.paulovieirajr.msclientes.core.domain.entities.Client;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;

import java.util.Optional;

public interface ClientRepositoryGateway {

    ClientModel save(Client client);

    Optional<ClientModel> findByCpf(String cpf);
}
