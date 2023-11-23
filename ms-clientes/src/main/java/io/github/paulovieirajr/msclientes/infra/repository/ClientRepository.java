package io.github.paulovieirajr.msclientes.infra.repository;

import io.github.paulovieirajr.msclientes.infra.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    @Query("SELECT c FROM ClientModel c WHERE c.cpf = ?1")
    Optional<ClientModel> findByCpf(String cpf);
}
