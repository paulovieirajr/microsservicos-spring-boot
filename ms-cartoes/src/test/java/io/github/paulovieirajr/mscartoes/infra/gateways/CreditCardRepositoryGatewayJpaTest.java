package io.github.paulovieirajr.mscartoes.infra.gateways;

import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.core.domain.CreditCard;
import io.github.paulovieirajr.mscartoes.infra.mapper.CreditCardMapper;
import io.github.paulovieirajr.mscartoes.infra.model.CreditCardModel;
import io.github.paulovieirajr.mscartoes.infra.repositories.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CreditCardRepositoryGatewayJpaTest {

    @Mock
    private CreditCardRepository creditCardRepository;

    @Mock
    private CreditCardMapper creditCardMapper;

    @InjectMocks
    private CreditCardRepositoryGatewayJpa creditCardRepositoryGatewayJpa;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should save credit card correctly")
    void shouldSaveCreditCardCorrectly() {
        CreditCard creditCard = new CreditCard("Test Card", CardNetwork.VISA, new BigDecimal("2000"), new BigDecimal("5000"));
        CreditCardModel creditCardModel = new CreditCardModel();
        when(creditCardMapper.toModel(any(CreditCard.class))).thenReturn(creditCardModel);
        when(creditCardRepository.save(any(CreditCardModel.class))).thenReturn(creditCardModel);

        CreditCardModel result = creditCardRepositoryGatewayJpa.save(creditCard);

        assertEquals(creditCardModel, result);
    }

    @Test
    @DisplayName("Should find credit cards by income correctly")
    void shouldFindCreditCardsByIncomeCorrectly() {
        CreditCardModel creditCardModel = new CreditCardModel();
        when(creditCardRepository.findByIncomeLessThanEqual(any(BigDecimal.class))).thenReturn(Collections.singletonList(creditCardModel));

        Collection<CreditCardModel> result = creditCardRepositoryGatewayJpa.findByIncomeLessThanEqual(2000L);

        assertEquals(1, result.size());
        assertEquals(creditCardModel, result.iterator().next());
    }
}