package io.github.paulovieirajr.msclientes.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.paulovieirajr.msclientes.api.dto.ClientRequest;
import io.github.paulovieirajr.msclientes.core.application.usecases.ClientRegisterUseCase;
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

@WebMvcTest(ClientRegisterController.class)
class ClientRegisterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientRegisterUseCase clientRegisterUseCase;

    @Nested
    @DisplayName("Create Client with correct values")
    class CreateClientWithCorrectValues {

        @DisplayName("Should create a Client with correct values")
        @Test
        void createClientWithCorrectValues() throws Exception {
            ClientRequest clientRequest = new ClientRequest("John Doe", "56010962013", 25);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(clientRequest)))
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }
    }

    @Nested
    @DisplayName("Throwing exception when creating Client with incorrect values")
    class CreateClientWithIncorrectValues {
        @DisplayName("Should throw exception when name is blank")
        @Test
        void createClientWithBlankName() throws Exception {
            ClientRequest clientRequest = new ClientRequest("", "56010962013", 25);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(clientRequest)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @DisplayName("Should throw exception when CPF is invalid")
        @Test
        void createClientWithInvalidCPF() throws Exception {
            ClientRequest clientRequest = new ClientRequest("John Doe", "123", 25);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(clientRequest)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @DisplayName("Should throw exception when age is null")
        @Test
        void createClientWithNullAge() throws Exception {
            ClientRequest clientRequest = new ClientRequest("John Doe", "56010962013", null);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(clientRequest)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @DisplayName("Should throw exception when age is not positive")
        @Test
        void createClientWithNonPositiveAge() throws Exception {
            ClientRequest clientRequest = new ClientRequest("John Doe", "56010962013", 0);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(clientRequest)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}