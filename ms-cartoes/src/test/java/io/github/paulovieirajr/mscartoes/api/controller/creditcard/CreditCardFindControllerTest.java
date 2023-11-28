package io.github.paulovieirajr.mscartoes.api.controller.creditcard;

import io.github.paulovieirajr.mscartoes.api.controller.creditcard.CreditCardFindController;
import io.github.paulovieirajr.mscartoes.core.application.usecases.creditcard.find.CreditCardFindByIncomeUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CreditCardFindController.class)
class CreditCardFindControllerTest {

    public static final String URI_API = "/api/v1/credit-cards";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreditCardFindByIncomeUseCase creditCardFindByIncomeUseCase;


    @Nested
    @DisplayName("Successful cases")
    class SuccessfulCases {

        @Test
        @DisplayName("Should return ResponseEntity with status 200")
        void shouldReturnResponseEntityWithStatus200() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get(URI_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("income", "10000"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
    }

    @Nested
    @DisplayName("Unsuccessful cases")
    class UnsuccessfulCases {

        @Test
        @DisplayName("Should return a bad request when income is zero")
        void shouldReturnABadRequestIncomeZero() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get(URI_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("income", "0"))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}