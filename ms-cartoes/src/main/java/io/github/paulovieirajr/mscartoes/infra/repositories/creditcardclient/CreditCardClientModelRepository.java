package io.github.paulovieirajr.mscartoes.infra.repositories.creditcardclient;

import io.github.paulovieirajr.mscartoes.infra.model.creditcardclient.CreditCardClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CreditCardClientModelRepository extends JpaRepository<CreditCardClientModel, Long> {

    @Query("SELECT c FROM CreditCardClientModel c WHERE c.cpf = ?1")
    Collection<CreditCardClientModel> findByCpf(String cpf);
}