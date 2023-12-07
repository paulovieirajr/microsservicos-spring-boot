package io.github.paulovieirajr.mscartoes.api.controller.creditcardclient;

import io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient.CreditCardClientFindByCpfUseCase;
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

@WebMvcTest(CreditCardClientFindController.class)
class CreditCardClientFindControllerTest {

    public static final String URI_API = "/api/v1/credit-cards/client";
    public static final String FAKE_VALID_CPF = "02522228064";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreditCardClientFindByCpfUseCase creditCardClientFindByCpfUseCase;

    @Nested
    @DisplayName("Successful cases")
    class SuccessfulCases {

        @Test
        @DisplayName("Should return ResponseEntity with status 200")
        void shouldReturnResponseEntityWithStatus200() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get(URI_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .queryParam("cpf", FAKE_VALID_CPF))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
    }
}