package io.github.paulovieirajr.msclientes.core.application.usecases;

public interface UseCase<T, R> {

    R execute(T t);
}
