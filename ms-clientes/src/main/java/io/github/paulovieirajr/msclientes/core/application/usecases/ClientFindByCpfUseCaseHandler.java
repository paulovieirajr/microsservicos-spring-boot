package io.github.paulovieirajr.msclientes.core.application.usecases;

import io.github.paulovieirajr.msclientes.api.dto.ClientResponse;
import io.github.paulovieirajr.msclientes.api.exception.BusinessException;
import io.github.paulovieirajr.msclientes.core.application.repositories.ClientRepositoryGateway;
import io.github.paulovieirajr.msclientes.core.domain.util.CpfValidator;
import io.github.paulovieirajr.msclientes.infra.model.ClientModel;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

public class ClientFindByCpfUseCaseHandler implements ClientFindByCpfUseCase {

    private final ClientRepositoryGateway clientRepositoryGateway;

    public ClientFindByCpfUseCaseHandler(ClientRepositoryGateway clientRepositoryGateway) {
        this.clientRepositoryGateway = clientRepositoryGateway;
    }

    @Override
    public ClientResponse execute(String cpf) {
        var cpfValidator = new CpfValidator();
        boolean cpfValidationResult = cpfValidator.isCpfValid(cpf);
        if (!cpfValidationResult) {
            throw new BusinessException("CPF inválido");
        }
        Optional<ClientModel> clientFound = clientRepositoryGateway.findByCpf(cpf);
        return clientFound.map(
                clientModel -> new ClientResponse(clientModel.getId(), clientModel.getName(), clientModel.getCpf(), clientModel.getAge())
        ).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado"));
    }
}
