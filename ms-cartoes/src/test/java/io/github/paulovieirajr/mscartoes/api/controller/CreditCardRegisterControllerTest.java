package io.github.paulovieirajr.mscartoes.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.paulovieirajr.mscartoes.api.dto.CreditCardRequest;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardRegisterUseCase;
import io.github.paulovieirajr.mscartoes.core.domain.CardNetwork;
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

import java.math.BigDecimal;

@WebMvcTest(CreditCardRegisterController.class)
class CreditCardRegisterControllerTest {

    public static final String URL_API = "/api/v1/credit-cards";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CreditCardRegisterUseCase creditCardRegisterUseCase;

    @Nested
    @DisplayName("Successful cases")
    class SuccessfulCases {

        @Test
        @DisplayName("Should return HttpStatus.CREATED when request is valid")
        void shouldReturnHttpStatusCreatedWhenRequestIsValid() throws Exception {
            CreditCardRequest request = new CreditCardRequest("Santander Visa Gold", CardNetwork.VISA,
                    BigDecimal.valueOf(10000), BigDecimal.valueOf(18000));
            mockMvc.perform(MockMvcRequestBuilders.post(URL_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request)))
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }
    }

    @Nested
    @DisplayName("Unsuccessful cases")
    class UnsuccessfulCases {

        @Test
        @DisplayName("Should return HttpStatus.BAD_REQUEST when name is blank")
        void shouldReturnHttpStatusBadRequestWhenNameIsBlank() throws Exception {
            CreditCardRequest request = new CreditCardRequest("", CardNetwork.VISA,
                    BigDecimal.valueOf(10000), BigDecimal.valueOf(18000));
            mockMvc.perform(MockMvcRequestBuilders.post(URL_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        @DisplayName("Should return HttpStatus.BAD_REQUEST when card network is null")
        void shouldReturnHttpStatusBadRequestWhenCardNetworkIsNull() throws Exception {
            CreditCardRequest request = new CreditCardRequest("Santander Visa Gold", null,
                    BigDecimal.valueOf(10000), BigDecimal.valueOf(18000));
            mockMvc.perform(MockMvcRequestBuilders.post(URL_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        @DisplayName("Should return HttpStatus.BAD_REQUEST when income is less than 1500")
        void shouldReturnHttpStatusBadRequestWhenIncomeIsLessThan1500() throws Exception {
            CreditCardRequest request = new CreditCardRequest("Santander Visa Gold", CardNetwork.VISA,
                    BigDecimal.valueOf( 1000), BigDecimal.valueOf(5000));
            mockMvc.perform(MockMvcRequestBuilders.post(URL_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}