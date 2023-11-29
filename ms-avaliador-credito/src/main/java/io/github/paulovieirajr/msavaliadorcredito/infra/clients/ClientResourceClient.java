package io.github.paulovieirajr.msavaliadorcredito.infra.clients;


import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.client.name}", path = "${feign.client.path}")
public interface ClientResourceClient {

    @GetMapping
    ResponseEntity<ClientResponse> execute(@RequestParam String cpf);
}
