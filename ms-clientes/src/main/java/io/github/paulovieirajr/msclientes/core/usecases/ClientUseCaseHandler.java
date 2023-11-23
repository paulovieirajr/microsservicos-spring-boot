package io.github.paulovieirajr.msclientes.core.usecases;

public interface ClientUseCaseHandler <T, R> {

    R execute(T t);
}
