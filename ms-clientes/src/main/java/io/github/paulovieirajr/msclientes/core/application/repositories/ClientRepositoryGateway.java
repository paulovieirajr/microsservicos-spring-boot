package io.github.paulovieirajr.msclientes.core.application.repositories;

import io.github.paulovieirajr.msclientes.core.domain.Client;

import java.util.Optional;

public interface ClientRepositoryGateway {

    Client save(Client client);

    Optional<Client> findByCpf(String cpf);
}
