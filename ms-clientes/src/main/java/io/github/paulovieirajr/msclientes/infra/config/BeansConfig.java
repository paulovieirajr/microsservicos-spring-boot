package io.github.paulovieirajr.msclientes.infra.config;

import io.github.paulovieirajr.msclientes.infra.repository.ClientRepository;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ClientRegisterUseCase clientRegisterUseCase(ClientRepository clientRepository) {
        return new ClientRegisterUseCase(clientRepository);
    }
}
