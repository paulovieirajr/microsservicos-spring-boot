package io.github.paulovieirajr.msclientes.core.domain.exception;

import java.io.Serial;

public class ClientException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
