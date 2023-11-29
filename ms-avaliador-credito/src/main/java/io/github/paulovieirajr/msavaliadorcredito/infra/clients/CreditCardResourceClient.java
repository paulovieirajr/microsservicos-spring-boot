package io.github.paulovieirajr.msavaliadorcredito.infra.clients;


import io.github.paulovieirajr.msavaliadorcredito.core.domain.CreditCardClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(value = "${feign.credit-card.name}", path = "${feign.credit-card.path}")
public interface CreditCardResourceClient {

    @GetMapping
    ResponseEntity<Collection<CreditCardClient>> execute(@RequestParam String cpf);
}
