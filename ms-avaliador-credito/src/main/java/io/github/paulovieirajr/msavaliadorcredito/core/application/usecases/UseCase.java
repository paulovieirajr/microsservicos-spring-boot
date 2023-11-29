package io.github.paulovieirajr.msavaliadorcredito.core.application.usecases;

public interface UseCase<T, R> {

    R execute(T t);
}
