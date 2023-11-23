package io.github.paulovieirajr.msclientes.api.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
