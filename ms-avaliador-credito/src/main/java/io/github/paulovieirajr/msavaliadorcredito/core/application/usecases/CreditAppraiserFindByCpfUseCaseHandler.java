package io.github.paulovieirajr.msavaliadorcredito.core.application.usecases;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetCreditCardByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientStatus;

public class CreditAppraiserFindByCpfUseCaseHandler implements CreditAppraiserFindByCpfUseCase {

    private final GetClientDataByCpfGateway getClientDataByCpfGateway;
    private final GetCreditCardByCpfGateway getCreditCardByCpfGateway;

    public CreditAppraiserFindByCpfUseCaseHandler(GetClientDataByCpfGateway getClientDataByCpfGateway,
                                                  GetCreditCardByCpfGateway getCreditCardByCpfGateway) {
        this.getClientDataByCpfGateway = getClientDataByCpfGateway;
        this.getCreditCardByCpfGateway = getCreditCardByCpfGateway;
    }

    @Override
    public ClientStatus execute(String cpf) {
        var clientDataResponse = getClientDataByCpfGateway.execute(cpf);
        var creditCardResponse = getCreditCardByCpfGateway.execute(cpf);
        return new ClientStatus(clientDataResponse, creditCardResponse);
    }
}
