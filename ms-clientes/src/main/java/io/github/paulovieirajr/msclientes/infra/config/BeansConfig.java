package io.github.paulovieirajr.msclientes.infra.config;

import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
import io.github.paulovieirajr.msclientes.infra.gateways.ClientRepositoryGatewayJpa;
import io.github.paulovieirajr.msclientes.infra.mapper.ClientMapper;
import io.github.paulovieirajr.msclientes.infra.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ClientRegisterUseCase clientRegisterUseCase(ClientRepositoryGateway clientRepositoryGateway) {
        return new ClientRegisterUseCase(clientRepositoryGateway);
    }

    @Bean
    public ClientRepositoryGateway clientRepositoryGateway(ClientRepository clientRepository, ClientMapper clientMapper) {
        return new ClientRepositoryGatewayJpa(clientRepository, clientMapper);
    }
}
