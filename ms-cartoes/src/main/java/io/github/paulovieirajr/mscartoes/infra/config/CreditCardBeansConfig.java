package io.github.paulovieirajr.mscartoes.infra.config;

import io.github.paulovieirajr.mscartoes.core.application.repositories.CreditCardRepositoryGateway;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardFindByIncomeUseCase;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardFindByIncomeUseCaseHandler;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardRegisterUseCase;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardRegisterUseCaseHandler;
import io.github.paulovieirajr.mscartoes.infra.gateways.CreditCardRepositoryGatewayJpa;
import io.github.paulovieirajr.mscartoes.infra.mapper.CreditCardMapper;
import io.github.paulovieirajr.mscartoes.infra.repositories.CreditCardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardBeansConfig {

    @Bean
    public CreditCardRepositoryGateway creditCardRepositoryGateway(
            CreditCardRepository creditCardRepository,
            CreditCardMapper creditCardMapper) {
        return new CreditCardRepositoryGatewayJpa(creditCardRepository, creditCardMapper);
    }

    @Bean
    public CreditCardRegisterUseCase creditCardRegisterUseCase(CreditCardRepositoryGateway creditCardRepositoryGateway) {
        return new CreditCardRegisterUseCaseHandler(creditCardRepositoryGateway);
    }

    @Bean
    public CreditCardFindByIncomeUseCase creditCardFindByIncomeUseCase(CreditCardRepositoryGateway creditCardRepositoryGateway) {
        return new CreditCardFindByIncomeUseCaseHandler(creditCardRepositoryGateway);
    }
}
