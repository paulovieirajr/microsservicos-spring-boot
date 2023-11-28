package io.github.paulovieirajr.mscartoes.infra.gateways.creditcard;

import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcard.CreditCardRepositoryGateway;
import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.mapper.CreditCardMapper;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;
import io.github.paulovieirajr.mscartoes.infra.repositories.creditcard.CreditCardRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;

@Repository
public class CreditCardRepositoryGatewayJpa implements CreditCardRepositoryGateway {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    public CreditCardRepositoryGatewayJpa(CreditCardRepository creditCardRepository, CreditCardMapper creditCardMapper) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardMapper = creditCardMapper;
    }

    @Override
    public CreditCardModel save(CreditCard client) {
        return creditCardRepository.save(creditCardMapper.toModel(client));
    }

    @Override
    public Collection<CreditCardModel> findByIncomeLessThanEqual(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return creditCardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
