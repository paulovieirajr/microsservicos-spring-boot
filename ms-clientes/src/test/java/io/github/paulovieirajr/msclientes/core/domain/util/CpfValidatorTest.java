package io.github.paulovieirajr.msclientes.core.domain.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfValidatorTest {

    private CpfValidator cpfValidator;

    @BeforeEach
    public void setup() {
        cpfValidator = new CpfValidator();
    }

    @DisplayName("Should return true when CPF is valid")
    @Test
    public void validCpf() {
        String cpf = "56010962013";
        assertTrue(cpfValidator.isCpfValid(cpf));
    }

    @DisplayName("Should return false when CPF is invalid")
    @Test
    public void invalidCpf() {
        String cpf = "12345678901";
        assertFalse(cpfValidator.isCpfValid(cpf));
    }

    @DisplayName("Should return false when CPF has incorrect length")
    @Test
    public void cpfWithIncorrectLength() {
        String cpf = "123456789";
        assertFalse(cpfValidator.isCpfValid(cpf));
    }

    @DisplayName("Should return false when CPF contains non-numeric characters")
    @Test
    public void cpfWithNonNumericCharacters() {
        String cpf = "5601096201a";
        assertFalse(cpfValidator.isCpfValid(cpf));
    }
}