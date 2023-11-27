package io.github.paulovieirajr.mscartoes.api.controller;

import io.github.paulovieirajr.mscartoes.api.dto.CreditCardResponse;
import io.github.paulovieirajr.mscartoes.api.exception.BusinessException;
import io.github.paulovieirajr.mscartoes.core.application.usecases.CreditCardFindByIncomeUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static io.github.paulovieirajr.mscartoes.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.mscartoes.api.constants.CreditCardControllerConstants.CREDIT_CARDS;

@RestController
@RequestMapping(API_VERSION + CREDIT_CARDS)
@Slf4j
public class CreditCardFindController {

    private final CreditCardFindByIncomeUseCase creditCardFindByIncomeUseCase;

    public CreditCardFindController(CreditCardFindByIncomeUseCase creditCardFindByIncomeUseCase) {
        this.creditCardFindByIncomeUseCase = creditCardFindByIncomeUseCase;
    }

    @GetMapping
    public ResponseEntity<Collection<CreditCardResponse>> findByIncome(@RequestParam Long income) {
        log.info("Endpoint called: GET /credit-cards/{}", income);
        if (income <= 0)
            throw new BusinessException("A renda informada é inválida. Devem ser informado um valor positivo.");
        var response = creditCardFindByIncomeUseCase.execute(income);
        return ResponseEntity.ok(response);
    }
}
