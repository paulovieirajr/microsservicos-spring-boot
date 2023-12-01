package io.github.paulovieirajr.msavaliadorcredito.core.application.usecases;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetRangeByIncomeGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentRequest;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentResponse;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ApprovedCreditCardClient;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientData;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;

import java.util.Collection;
import java.util.List;

public class CreditAppraiserAssessmentUseCaseHandler implements CreditAppraiserAssessmentUseCase{

    private final GetClientDataByCpfGateway getClientDataByCpfGateway;
    private final GetRangeByIncomeGateway getRangeByIncomeGateway;

    public CreditAppraiserAssessmentUseCaseHandler(GetClientDataByCpfGateway getClientDataByCpfGateway,
                                                   GetRangeByIncomeGateway getRangeByIncomeGateway) {
        this.getClientDataByCpfGateway = getClientDataByCpfGateway;
        this.getRangeByIncomeGateway = getRangeByIncomeGateway;
    }

    @Override
    public ClientDataAssessmentResponse execute(ClientDataAssessmentRequest clientDataAssessmentRequest) {
        ClientData clientData = getClientDataByCpfGateway.execute(clientDataAssessmentRequest.cpf());
        Collection<CreditCardClient> creditCardClients = getRangeByIncomeGateway.execute(clientDataAssessmentRequest.income());

        var approvedCreditCardClients = ApprovedCreditCardClient.mapToApprovedCreditCards(creditCardClients, clientData);

        return new ClientDataAssessmentResponse(approvedCreditCardClients);
    }
}
