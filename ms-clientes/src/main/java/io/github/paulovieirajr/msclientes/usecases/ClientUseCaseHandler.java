package io.github.paulovieirajr.msclientes.usecases;

public interface ClientUseCaseHandler <T, R> {

    R execute(T t);
}
