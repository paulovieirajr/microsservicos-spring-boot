package io.github.paulovieirajr.msavaliadorcredito.infra.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientData;
import io.github.paulovieirajr.msavaliadorcredito.infra.clients.ClientResourceClient;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientResponse;
import org.springframework.http.ResponseEntity;

public class GetClientDataByCpf implements GetClientDataByCpfGateway {

    private final ClientResourceClient clientResourceClient;

    public GetClientDataByCpf(ClientResourceClient clientResourceClient) {
        this.clientResourceClient = clientResourceClient;
    }

    @Override
    public ClientData execute(String cpf) {
        ResponseEntity<ClientResponse> clientResponse = clientResourceClient.execute(cpf);
        return ClientData.of(clientResponse);
    }
}
