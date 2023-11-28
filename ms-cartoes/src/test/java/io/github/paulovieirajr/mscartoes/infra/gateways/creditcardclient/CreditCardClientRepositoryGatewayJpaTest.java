package io.github.paulovieirajr.mscartoes.infra.gateways.creditcardclient;

import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;
import io.github.paulovieirajr.mscartoes.infra.repositories.creditcardclient.CreditCardClientModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CreditCardClientRepositoryGatewayJpaTest {

    public static final String FAKE_CPF = "02522228064";

    @Mock
    private CreditCardClientModelRepository creditCardClientModelRepository;

    @InjectMocks
    private CreditCardClientRepositoryGatewayJpa creditCardClientRepositoryGatewayJpa;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should find credit card clients by CPF correctly")
    void shouldFindCreditCardClientsByCpfCorrectly() {
        CreditCardClientModel creditCardClientModel = new CreditCardClientModel();
        when(creditCardClientModelRepository.findByCpf(any(String.class))).thenReturn(Collections.singletonList(creditCardClientModel));

        Collection<CreditCardClientModel> result = creditCardClientRepositoryGatewayJpa.findByCpf(FAKE_CPF);

        assertEquals(1, result.size());
        assertEquals(creditCardClientModel, result.iterator().next());
    }

    @Test
    @DisplayName("Should return empty collection when no credit card clients found by CPF")
    void shouldReturnEmptyCollectionWhenNoCreditCardClientsFoundByCpf() {
        when(creditCardClientModelRepository.findByCpf(any(String.class))).thenReturn(Collections.emptyList());

        Collection<CreditCardClientModel> result = creditCardClientRepositoryGatewayJpa.findByCpf(FAKE_CPF);

        assertEquals(0, result.size());
    }
}