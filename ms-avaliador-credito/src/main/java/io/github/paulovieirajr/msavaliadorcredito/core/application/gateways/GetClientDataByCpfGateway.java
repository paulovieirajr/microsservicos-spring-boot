package io.github.paulovieirajr.msavaliadorcredito.core.application.gateways;

import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientData;

public interface GetClientDataByCpfGateway {

    ClientData execute(String cpf);
}
