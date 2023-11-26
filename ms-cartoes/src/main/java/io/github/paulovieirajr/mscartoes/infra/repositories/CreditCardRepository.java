package io.github.paulovieirajr.mscartoes.infra.repositories;

import io.github.paulovieirajr.mscartoes.infra.model.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;

public interface CreditCardRepository extends JpaRepository<CreditCardModel, Long> {

    @Query("SELECT c FROM CreditCardModel c WHERE c.income <= ?1")
    Collection<CreditCardModel> findByIncomeLessThanEqual(BigDecimal income);
}