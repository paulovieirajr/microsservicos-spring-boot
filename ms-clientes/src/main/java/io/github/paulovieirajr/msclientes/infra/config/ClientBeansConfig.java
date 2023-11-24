package io.github.paulovieirajr.msclientes.infra.config;

import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCase;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCaseHandler;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCaseHandler;
import io.github.paulovieirajr.msclientes.infra.gateways.ClientRepositoryGatewayJpa;
import io.github.paulovieirajr.msclientes.infra.mapper.ClientMapper;
import io.github.paulovieirajr.msclientes.infra.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientBeansConfig {

    @Bean
    public ClientRegisterUseCase clientRegisterUseCase(ClientRepositoryGateway clientRepositoryGateway) {
        return new ClientRegisterUseCaseHandler(clientRepositoryGateway);
    }

    @Bean
    public ClientFindByCpfUseCase clientFindByCpfUseCase(ClientRepositoryGateway clientRepositoryGateway) {
        return new ClientFindByCpfUseCaseHandler(clientRepositoryGateway);
    }

    @Bean
    public ClientRepositoryGateway clientRepositoryGateway(ClientRepository clientRepository, ClientMapper clientMapper) {
        return new ClientRepositoryGatewayJpa(clientRepository, clientMapper);
    }
}
