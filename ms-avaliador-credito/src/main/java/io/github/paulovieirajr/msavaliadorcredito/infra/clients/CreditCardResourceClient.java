package io.github.paulovieirajr.msavaliadorcredito.infra.clients;


import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(value = "${feign.credit-cards.name}", path = "${feign.credit-cards.path}")
public interface CreditCardResourceClient {

    @GetMapping
    ResponseEntity<Collection<CreditCardClient>> findByIncome(@RequestParam Long income);

    @GetMapping("/client")
    ResponseEntity<Collection<CreditCardClient>> getCreditCardsByCpf(@RequestParam String cpf);

}
