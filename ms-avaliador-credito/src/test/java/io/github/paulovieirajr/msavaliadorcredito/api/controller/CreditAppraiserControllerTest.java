package io.github.paulovieirajr.msavaliadorcredito.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentRequest;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserAssessmentUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserFindByCpfUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreditAppraiserController.class)
class CreditAppraiserControllerTest {
    private static final String URL_API = "/api/v1/credit-appraiser";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase;

    @MockBean
    CreditAppraiserAssessmentUseCase creditAppraiserAssessmentUseCase;

    @Nested
    @DisplayName("Successful cases")
    class SuccessfulCases {

        private static final String CPF_VALID = "40806015063";
        private static final Long INCOME = 2000L;
        private static final ClientDataAssessmentRequest CLIENT_DATA_ASSESSMENT_REQUEST_MOCK = new ClientDataAssessmentRequest(
                CPF_VALID,
                INCOME
        );

        @Test
        @DisplayName("Should return HttpStatus.OK when CPF is valid")
        void shouldReturnHttpStatusOkWhenCpfIsValid() throws Exception {
            mockMvc.perform(get(URL_API)
                            .param("cpf", CPF_VALID))
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Should return HttpStatus.OK when request is valid")
        void shouldReturnHttpStatusOkWhenRequestIsValid() throws Exception {
            mockMvc.perform(post(URL_API + "/assessment")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(CLIENT_DATA_ASSESSMENT_REQUEST_MOCK)))
                    .andExpect(status().isOk());
        }
    }

    @Nested
    @DisplayName("Unsuccessful cases")
    class UnsuccessfulCases {

        private static final String CPF_INVALID = "40806015060";
        private static final Long INCOME = 1000L;
        private static final ClientDataAssessmentRequest CLIENT_DATA_ASSESSMENT_REQUEST_MOCK = new ClientDataAssessmentRequest(
                CPF_INVALID,
                INCOME
        );

        @Test
        @DisplayName("Should return HttpStatus.BAD_REQUEST when CPF is invalid")
        void shouldReturnHttpStatusOkWhenCpfIsValid() throws Exception {
            mockMvc.perform(get(URL_API)
                            .param("cpf", CPF_INVALID))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("Should return HttpStatus.BAD_REQUEST when request is invalid")
        void shouldReturnHttpStatusOkWhenRequestIsValid() throws Exception {
            mockMvc.perform(post(URL_API + "/assessment")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(CLIENT_DATA_ASSESSMENT_REQUEST_MOCK)))
                    .andExpect(status().isBadRequest());
        }
    }
}