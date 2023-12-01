package io.github.paulovieirajr.msavaliadorcredito.infra.config;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetCreditCardByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetRangeByIncomeGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserAssessmentUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserAssessmentUseCaseHandler;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserFindByCpfUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserFindByCpfUseCaseHandler;
import io.github.paulovieirajr.msavaliadorcredito.infra.clients.ClientResourceClient;
import io.github.paulovieirajr.msavaliadorcredito.infra.clients.CreditCardResourceClient;
import io.github.paulovieirajr.msavaliadorcredito.infra.gateways.GetClientDataByCpf;
import io.github.paulovieirajr.msavaliadorcredito.infra.gateways.GetCreditCardByCpf;
import io.github.paulovieirajr.msavaliadorcredito.infra.gateways.GetRangeByIncome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditAppraiserBeanConfig {

    @Bean
    public CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase(GetClientDataByCpfGateway getClientDataByCpfGateway,
                                                                           GetCreditCardByCpfGateway getCreditCardByCpfGateway) {
        return new CreditAppraiserFindByCpfUseCaseHandler(getClientDataByCpfGateway, getCreditCardByCpfGateway);
    }

    @Bean
    public CreditAppraiserAssessmentUseCase creditAppraiserAssessmentUseCase(GetClientDataByCpfGateway getClientDataByCpfGateway,
                                                                             GetRangeByIncomeGateway getRangeByIncomeGateway) {
        return new CreditAppraiserAssessmentUseCaseHandler(getClientDataByCpfGateway, getRangeByIncomeGateway);
    }

    @Bean
    public GetClientDataByCpfGateway getClientStatusByCpfGateway(ClientResourceClient clientResourceClient) {
        return new GetClientDataByCpf(clientResourceClient);
    }

    @Bean
    public GetCreditCardByCpfGateway getCreditCardByCpfGateway(CreditCardResourceClient creditCardResourceClient) {
        return new GetCreditCardByCpf(creditCardResourceClient);
    }

    @Bean
    public GetRangeByIncomeGateway getRangeByIncomeGateway(CreditCardResourceClient creditCardResourceClient) {
        return new GetRangeByIncome(creditCardResourceClient);
    }
}
