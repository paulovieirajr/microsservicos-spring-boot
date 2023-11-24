package io.github.paulovieirajr.msclientes.infra.mapper;

import io.github.paulovieirajr.msclientes.core.domain.Client;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientModel toModel(Client client) {
        return new ClientModel(client.getName(), client.getCpf(), client.getAge());
    }
}
