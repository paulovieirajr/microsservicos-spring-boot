package io.github.paulovieirajr.mscartoes.core.application.usecases;

public interface UseCase<T, R> {

    R execute(T t);
}
