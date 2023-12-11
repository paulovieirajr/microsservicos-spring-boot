package io.github.paulovieirajr.msavaliadorcredito.core.application.usecases;

import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetClientDataByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.application.gateways.GetCreditCardByCpfGateway;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientData;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientStatus;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static io.github.paulovieirajr.msavaliadorcredito.core.domain.CardNetwork.MASTERCARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CreditAppraiserFindByCpfUseCaseTest {

    private static final String CPF_VALID = "40806015063";
    public static final long CLIENT_ID = 1L;
    private static final String CLIENT_NAME = "John Doe";
    public static final int CLIENT_AGE = 25;
    public static final BigDecimal CREDIT_LIMIT = BigDecimal.valueOf(10000);
    public static final Long INCOME = 5000L;

    @Mock
    private GetClientDataByCpfGateway getClientDataByCpfGateway;

    @Mock
    private GetCreditCardByCpfGateway getCreditCardByCpfGateway;

    @InjectMocks
    private CreditAppraiserFindByCpfUseCaseHandler creditAppraiserFindByCpfUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAClientStatusWhenClientDataIsValid() {
        when(getClientDataByCpfGateway.execute(CPF_VALID)).thenReturn(getClientDataStub());
        when(getCreditCardByCpfGateway.execute(CPF_VALID)).thenReturn(List.of(getCreditCardClientStub()));

        ClientStatus clientStatus = creditAppraiserFindByCpfUseCase.execute(CPF_VALID);

        assertEquals(getClientStatusStub(), clientStatus);
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

    private ClientStatus getClientStatusStub() {
        return new ClientStatus(
                getClientDataStub(),
                List.of(getCreditCardClientStub())
        );
    }
}