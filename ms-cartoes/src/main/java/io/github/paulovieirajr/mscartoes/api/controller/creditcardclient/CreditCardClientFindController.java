package io.github.paulovieirajr.mscartoes.api.controller.creditcardclient;

import io.github.paulovieirajr.mscartoes.api.dto.creditcardclient.CreditCardClientResponse;
import io.github.paulovieirajr.mscartoes.core.application.usecases.creditcardclient.CreditCardClientFindByCpfUseCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static io.github.paulovieirajr.mscartoes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.mscartoes.api.constants.CreditCardControllerConstants.CLIENT;
import static io.github.paulovieirajr.mscartoes.api.constants.CreditCardControllerConstants.CREDIT_CARDS;

@RestController
@Validated
@RequestMapping(API_VERSION + CREDIT_CARDS)
@Slf4j
public class CreditCardClientFindController {

    private final CreditCardClientFindByCpfUseCase creditCardClientFindByCpfUseCase;

    public CreditCardClientFindController(CreditCardClientFindByCpfUseCase creditCardClientFindByCpfUseCase) {
        this.creditCardClientFindByCpfUseCase = creditCardClientFindByCpfUseCase;
    }

    @GetMapping(CLIENT)
    public ResponseEntity<Collection<CreditCardClientResponse>> findByCpf(
            @RequestParam @CPF(message = "O CPF fornecido é inválido") String cpf) {
        log.info("Endpoint called: GET /credit-cards/{}", cpf);
        var response = creditCardClientFindByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(response);
    }
}
