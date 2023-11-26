package io.github.paulovieirajr.mscartoes.api.controller;

import io.github.paulovieirajr.mscartoes.api.dto.CreditCardRequest;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardRegisterUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.paulovieirajr.mscartoes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.mscartoes.api.constants.CreditCardControllerConstants.CREDIT_CARDS;

@RestController
@RequestMapping(API_VERSION + CREDIT_CARDS)
@Slf4j
public class CreditCardRegisterController {

    private final CreditCardRegisterUseCase creditCardRegisterUseCase;

    public CreditCardRegisterController(CreditCardRegisterUseCase creditCardRegisterUseCase) {
        this.creditCardRegisterUseCase = creditCardRegisterUseCase;
    }

    @PostMapping
    public ResponseEntity<?> registerCard(@RequestBody @Valid CreditCardRequest request) {
        var response = creditCardRegisterUseCase.execute(request);
        log.info("Credit card registered: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
