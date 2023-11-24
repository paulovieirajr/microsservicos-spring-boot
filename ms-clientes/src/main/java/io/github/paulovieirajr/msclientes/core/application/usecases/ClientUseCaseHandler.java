package io.github.paulovieirajr.msclientes.core.application.usecases;

public interface ClientUseCaseHandler <T, R> {

    R execute(T t);
}
