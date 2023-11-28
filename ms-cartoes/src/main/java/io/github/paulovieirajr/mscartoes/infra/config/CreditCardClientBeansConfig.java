package io.github.paulovieirajr.mscartoes.infra.config;

import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcardclient.CreditCardClientRepositoryGateway;
import io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient.CreditCardClientFindByCpfUseCase;
import io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient.CreditCardClientFindByCpfUseCaseHandler;
import io.github.paulovieirajr.mscartoes.infra.gateways.creditcardclient.CreditCardClientRepositoryGatewayJpa;
import io.github.paulovieirajr.mscartoes.infra.repositories.creditcardclient.CreditCardClientModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardClientBeansConfig {

    @Bean
    public CreditCardClientRepositoryGateway creditCardClientRepositoryGateway(
            CreditCardClientModelRepository creditCardClientModelRepository) {
        return new CreditCardClientRepositoryGatewayJpa(creditCardClientModelRepository);
    }

    @Bean
    public CreditCardClientFindByCpfUseCase creditCardClientFindByCpfUseCase(
            CreditCardClientRepositoryGateway creditCardClientRepositoryGateway) {
        return new CreditCardClientFindByCpfUseCaseHandler(creditCardClientRepositoryGateway);
    }

}
