package io.github.paulovieirajr.msavaliadorcredito.api.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
