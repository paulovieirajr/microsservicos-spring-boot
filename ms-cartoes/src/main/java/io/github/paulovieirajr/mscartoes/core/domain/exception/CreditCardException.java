package io.github.paulovieirajr.mscartoes.core.domain.exception;

import java.io.Serial;

public class CreditCardException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CreditCardException(String message) {
        super(message);
    }
}
