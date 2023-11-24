package io.github.paulovieirajr.msclientes.api.controller;

import io.github.paulovieirajr.msclientes.core.application.usecases.ClientFindByCpfUseCase;
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

@WebMvcTest(ClientFindByCpfController.class)
class ClientFindByCpfControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientFindByCpfUseCase clientClientFindByCpfUseCase;


    @Nested
    @DisplayName("Find Client by CPF with correct values")
    class FindClientByCpfWithCorrectValues {

        @DisplayName("Should create a Client with correct values")
        @Test
        void findClientWithValidCpf() throws Exception {
            String VALID_CPF = "56010962013";
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("cpf", VALID_CPF))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
    }
}