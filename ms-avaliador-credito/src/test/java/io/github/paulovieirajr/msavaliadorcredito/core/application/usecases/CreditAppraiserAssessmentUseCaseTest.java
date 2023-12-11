package io.github.paulovieirajr.msavaliadorcredito.core.application.usecases;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetRangeByIncomeGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentRequest;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentResponse;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ApprovedCreditCardClient;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientData;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;

import static io.github.paulovieirajr.msavaliadorcredito.core.domain.CardNetwork.MASTERCARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class CreditAppraiserAssessmentUseCaseTest {

    private static final String CPF_VALID = "40806015063";
    public static final long CLIENT_ID = 1L;
    private static final String CLIENT_NAME = "John Doe";
    public static final int CLIENT_AGE = 25;
    public static final BigDecimal CREDIT_LIMIT = BigDecimal.valueOf(10000);
    public static final Long INCOME = 5000L;

    @Mock
    private GetClientDataByCpfGateway getClientDataByCpfGateway;

    @Mock
    private GetRangeByIncomeGateway getRangeByIncomeGateway;

    @InjectMocks
    private CreditAppraiserAssessmentUseCaseHandler creditAppraiserAssessmentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnApprovedCreditCardsWhenClientDataIsValid() {
        when(getClientDataByCpfGateway.execute(CPF_VALID)).thenReturn(getClientDataStub());
        when(getRangeByIncomeGateway.execute(INCOME)).thenReturn(Collections.singletonList(getCreditCardClientStub()));

        ClientDataAssessmentRequest clientDataAssessmentRequest = new ClientDataAssessmentRequest(CPF_VALID, INCOME);
        ClientDataAssessmentResponse clientDataAssessmentResponse = creditAppraiserAssessmentUseCase.execute(clientDataAssessmentRequest);
        ApprovedCreditCardClient approvedCreditCardClientStub = getApprovedCreditCardClientStub();

        assertEquals(1, clientDataAssessmentResponse.approvedCreditCards().size());
        assertTrue(clientDataAssessmentResponse.approvedCreditCards().contains(approvedCreditCardClientStub));
    }



    @Test
    void shouldReturnEmptySetWhenNoCreditCardsAreApproved() {
        when(getClientDataByCpfGateway.execute(CPF_VALID)).thenReturn(getClientDataStub());
        when(getRangeByIncomeGateway.execute(INCOME)).thenReturn(Collections.emptyList());

        ClientDataAssessmentRequest clientDataAssessmentRequest = new ClientDataAssessmentRequest(CPF_VALID, INCOME);
        ClientDataAssessmentResponse clientDataAssessmentResponse = creditAppraiserAssessmentUseCase.execute(clientDataAssessmentRequest);

        assertTrue(clientDataAssessmentResponse.approvedCreditCards().isEmpty());
    }

    private ClientData getClientDataStub() {
        return new ClientData(
                CLIENT_ID,
                CLIENT_NAME,
                CLIENT_AGE
        );
    }

    private CreditCardClient getCreditCardClientStub() {
        return new CreditCardClient(
                CLIENT_NAME,
                MASTERCARD,
                CREDIT_LIMIT
        );
    }

    private static ApprovedCreditCardClient getApprovedCreditCardClientStub() {
        return new ApprovedCreditCardClient(
                CLIENT_NAME,
                MASTERCARD,
                CREDIT_LIMIT,
                CLIENT_AGE
        );
    }
}