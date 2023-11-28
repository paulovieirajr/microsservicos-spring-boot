package io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient;

import io.github.paulovieirajr.mscartoes.api.dto.creditcardclient.CreditCardClientResponse;
import io.github.paulovieirajr.mscartoes.core.application.repositories.creditcardclient.CreditCardClientRepositoryGateway;
import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
import io.github.paulovieirajr.mscartoes.infra.model.creditcard.CreditCardModel;
import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;
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

class CreditCardClientFindByCpfUseCaseHandlerTest {

    public static final String FAKE_CPF = "02522228064";

    @Mock
    private CreditCardClientRepositoryGateway creditCardClientRepositoryGateway;

    @InjectMocks
    private CreditCardClientFindByCpfUseCaseHandler creditCardClientFindByCpfUseCaseHandler;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should return credit card clients by CPF correctly")
    void shouldReturnCreditCardClientsByCpfCorrectly() {
        CreditCardClientModel creditCardClientModel = generateCreditCardClientModelStub();
        when(creditCardClientRepositoryGateway.findByCpf(any(String.class))).thenReturn(Collections.singletonList(creditCardClientModel));

        Collection<CreditCardClientResponse> result = creditCardClientFindByCpfUseCaseHandler.execute(FAKE_CPF);

        assertEquals(1, result.size());
    }

    private CreditCardModel generateCreditCardModelStub() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setId(1L);
        creditCardModel.setName("Test Card");
        creditCardModel.setCardNetwork(CardNetwork.VISA);
        creditCardModel.setIncome(new BigDecimal("2000"));
        creditCardModel.setCreditLimit(new BigDecimal("5000"));
        return creditCardModel;
    }

    private CreditCardClientModel generateCreditCardClientModelStub() {
        CreditCardClientModel creditCardClientModel = new CreditCardClientModel();
        creditCardClientModel.setId(1L);
        creditCardClientModel.setCpf(FAKE_CPF);
        creditCardClientModel.setCreditCard(generateCreditCardModelStub());
        creditCardClientModel.setCreditLimit(new BigDecimal("5000"));
        return creditCardClientModel;
    }

    @Test
    @DisplayName("Should return empty collection when no credit card clients found by CPF")
    void shouldReturnEmptyCollectionWhenNoCreditCardClientsFoundByCpf() {
        when(creditCardClientRepositoryGateway.findByCpf(any(String.class))).thenReturn(Collections.emptyList());

        Collection<CreditCardClientResponse> result = creditCardClientFindByCpfUseCaseHandler.execute(FAKE_CPF);

        assertEquals(0, result.size());
    }
}